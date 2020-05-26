package com.github.gkttk.annotationConfig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Bean3 {
    private String name;
    private BeanRef3 ref;

    @Autowired
    public Bean3(@Value("Анатолий") String name, BeanRef3 ref) {
        this.name = name;
        this.ref = ref;
    }

    @PostConstruct
    private void init(){
        System.out.println("init-method in Bean3");
    }

    @PreDestroy
    private void destroy(){
        System.out.println("destroy-method in Bean3");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BeanRef3 getRef() {
        return ref;
    }

    public void setRef(BeanRef3 ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return name + " " + ref;
    }
}
