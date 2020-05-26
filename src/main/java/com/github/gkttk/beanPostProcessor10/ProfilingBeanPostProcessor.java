package com.github.gkttk.beanPostProcessor10;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProfilingBeanPostProcessor implements BeanPostProcessor {
    List<String> methodNames = new ArrayList<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Profiling.class)) {
                methodNames.add(declaredMethod.getName());
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!methodNames.isEmpty()) {
            Class<?> beanClass = bean.getClass();
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (methodNames.contains(method.getName())) {
                        long start = System.nanoTime();
                        Object returnValue = method.invoke(bean, args);
                        long finish = System.nanoTime();
                        System.out.println("Метод " + method.getName() + " отработал за " + (finish - start) + " наносекунд.");
                        methodNames.remove(method.getName());
                        return returnValue;
                    } else {
                        return method.invoke(bean, args);
                    }
                }
            });

        }

        return bean;
    }


}


