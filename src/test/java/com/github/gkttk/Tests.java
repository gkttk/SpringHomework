package com.github.gkttk;

import com.github.gkttk.xmlConfig1.Bean1;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tests {


    @Test
    public void testXmlConfig1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xmlConfig.xml");
        Bean1 bean1 = context.getBean("bean1", Bean1.class);
        System.out.println("--------");
        System.out.println(bean1.toString());
        System.out.println(bean1.getBean2().getNumber());
        context.close();
    }




}
