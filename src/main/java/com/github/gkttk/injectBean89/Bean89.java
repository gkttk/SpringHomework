package com.github.gkttk.injectBean89;

import com.github.gkttk.injectBean89.apiBean.BeanMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource(value = "bean89.properties", encoding = "utf-8")
public class Bean89 {

    @Value("${bean89.name}")             //инжект значения через проперти-файл, задание 9
    private String name;
    @Value("${bean89.age}")             //  -//-//-//-
    private int age;

    List<BeanMarker> beansList;

    @Autowired
    public Bean89(List<BeanMarker> beansList) {   //инжект листа бинов, задание 8
        this.beansList = beansList;
    }

    public List<BeanMarker> getBeansList() {
        return beansList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
