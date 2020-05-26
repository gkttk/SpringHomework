package com.github.gkttk.xmlConfig1;

public class RefBean1 {
    private int number;

    public RefBean1() {
        System.out.println("RefBean constructor");
    }

    private void init() {
        System.out.println("Init-method in RefBean");
    }

    private void destroy() {
        System.out.println("destroy-method in RefBean");
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
