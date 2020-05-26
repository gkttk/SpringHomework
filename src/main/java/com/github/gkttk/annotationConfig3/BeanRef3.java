package com.github.gkttk.annotationConfig3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanRef3 {
    @Value("Вассерман")
    private String surname;

    @PostConstruct
    private void init(){
        System.out.println("init-method in BeanRef3");
    }

    @PreDestroy
    private void destroy(){
        System.out.println("destroy-method in BeanRef3");
    }



    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
