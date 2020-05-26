package com.github.gkttk;

import com.github.gkttk.annotationConfig3.Bean3;
import com.github.gkttk.beanPostProcessor10.Bean10;
import com.github.gkttk.injectBean89.Bean89;
import com.github.gkttk.injectBeans47.Bean47;
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
        context.scan("com/github/gkttk/injectBeans47");
        context.scan("com/github/gkttk/injectBeans47/apiBean");
        context.refresh();
        Bean47 bean47 = context.getBean("bean47", Bean47.class);
        System.out.println("Инжект через поле, задание 4: " + bean47.getBeanFieldInject().getName());
        System.out.println("Инжект через сеттер, задание 5: " + bean47.getBeanSetterInject().getName());
        System.out.println("Инжект через конструктор, задание 6: " + bean47.getBeanCounstructorInject().getName());
        System.out.println("Первый бин с общим интерфейсом BeanMarker, задание 7: " + bean47.getBeanMarker1().getName());
        System.out.println("Второй бин с общим интерфейсом BeanMarker, задание 7: " + bean47.getBeanMarker2().getName());

        context.close();
    }


    @Test
    public void testInjects5(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com/github/gkttk/injectBean89");
        context.refresh();
        Bean89 bean89 = context.getBean("bean89", Bean89.class);

        bean89.getBeansList().forEach(bean-> System.out.println(bean.getName() + " " + bean.getClass()));

        System.out.println("Поле name через property-file: " + bean89.getName());
        System.out.println("Поле age через property-file: " + bean89.getAge());


        context.close();
    }


    @Test
    public void testProfiling6(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com/github/gkttk/beanPostProcessor10");
        context.refresh();
        Bean10 bean10Impl = context.getBean("bean10Impl", Bean10.class);
        System.out.println("---------------------");
        int count = bean10Impl.count();
        System.out.println("count = " + count);
        System.out.println("---------------------");
        bean10Impl.threads();
        System.out.println("---------------------");
        String str = bean10Impl.waitString();
        System.out.println("waitString строка = " + str);
        System.out.println("---------------------");
        bean10Impl.init();
        bean10Impl.destroy();
        System.out.println("---------------------");
        context.close();
    }




}
