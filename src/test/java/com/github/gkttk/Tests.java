package com.github.gkttk;

import com.github.gkttk.annotationConfig3.Bean3;
import com.github.gkttk.injectBeans.Bean49;
import com.github.gkttk.javaConfig2.Bean2;
import com.github.gkttk.javaConfig2.Config;
import com.github.gkttk.javaConfig2.componentScan.Bean2Scan;
import com.github.gkttk.xmlConfig1.Bean1;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tests {


    @Test
    public void testXmlConfig1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xmlConfig.xml");
        Bean1 bean1 = context.getBean("bean1", Bean1.class);
        System.out.println("--------");
        System.out.println(bean1.toString());
        System.out.println(bean1.getBean2().getNumber());
        bean1.getList().forEach(System.out::println);
        System.out.println("--------");
        context.close();
    }

    @Test
    public void testJavaConfig2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Bean2 bean2 = context.getBean("bean2", Bean2.class);
        System.out.println("--------");
        System.out.println(bean2.toString());
        System.out.println(bean2.getRef().getNumber());
        System.out.println("--------");
        Bean2Scan bean2Scan = context.getBean(Bean2Scan.class);
        System.out.println("Поле из отсканированного бина через ComponentScan - " + bean2Scan.isTrue());
        context.close();
    }


    @Test
    public void testAnnotationConfig3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com/github/gkttk/annotationConfig3");
        context.refresh();
        System.out.println("--------");
        Bean3 bean3 = context.getBean("bean3", Bean3.class);
        String fullName = bean3.getName() + " " + bean3.getRef().getSurname();
        System.out.println("Имя + Фамилия = " + fullName);
        System.out.println("--------");
        context.close();

    }


    @Test
    public void testInjects4(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com/github/gkttk/injectBeans");
        context.scan("com/github/gkttk/injectBeans/apiBean");
        context.refresh();
        Bean49 bean49 = context.getBean("bean49", Bean49.class);
        System.out.println("Инжект через поле, задание 4: " + bean49.getBeanFieldInject().getName());
        System.out.println("Инжект через сеттер, задание 5: " + bean49.getBeanSetterInject().getName());
        System.out.println("Инжект через конструктор, задание 6: " + bean49.getBeanCounstructorInject().getName());
        System.out.println("Первый бин с общим интерфейсом BeanMarker, задание 7: " + bean49.getBeanMarker1().getName());
        System.out.println("Второй бин с общим интерфейсом BeanMarker, задание 7: " + bean49.getBeanMarker2().getName());

        context.close();
    }




}
