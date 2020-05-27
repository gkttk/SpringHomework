package com.github.gkttk.beanPostProcessor10;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

@Component
public class ProfilingBeanPostProcessor implements BeanPostProcessor {

    Map<String, List<Method>> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Profiling.class)) {
                Method method = null;
                if (!map.containsKey(beanName)) {
                    map.put(beanName, new ArrayList<>());
                }

                List<Class<?>> interfaces = Arrays.asList(beanClass.getInterfaces());

                for (Class<?> anInterface : interfaces) {
                    try {
                        method = anInterface.getMethod(declaredMethod.getName(), declaredMethod.getParameterTypes());
                    } catch (NoSuchMethodException e) {
                        continue;
                    }
                }
                map.get(beanName).add(method);

            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (map.containsKey(beanName)) {
            Class<?> beanClass = bean.getClass();
            List<Method> methods = map.get(beanName);
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (methods.contains(method)) {
                        long start = System.nanoTime();
                        Object returnValue = method.invoke(bean, args);
                        long finish = System.nanoTime();
                        System.out.println("Метод " + method.getName() + " отработал за " + (finish - start) + " наносекунд.");
                        methods.remove(method);
                        if (methods.size() == 0) {
                            map.remove(beanName);
                        }
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


