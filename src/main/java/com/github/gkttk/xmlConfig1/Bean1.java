package com.github.gkttk.xmlConfig1;

import java.util.ArrayList;
import java.util.List;

public class Bean1 {
    private String name;
    private RefBean1 bean2;
    private List<String> list = new ArrayList<>();

    public Bean1(String name, RefBean1 bean2) {
        this.name = name;
        this.bean2 = bean2;
        System.out.println("Bean1 Constructor");
    }

    private void init() {
        System.out.println("Init-method in Bean1");
    }

    private void destroy() {
        System.out.println("destroy-method in Bean1");
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RefBean1 getBean2() {
        return bean2;
    }

    public void setBean2(RefBean1 bean2) {
        this.bean2 = bean2;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return name + " " + bean2;
    }
}
