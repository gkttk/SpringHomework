package com.github.gkttk.beanPostProcessor10;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Bean10Impl implements Bean10 {

    private static boolean isRun = true;


    @PostConstruct
    @Profiling
    public void init(){
        System.out.println("В init методе");
    }

    @Profiling
    public void init(String a){
        System.out.println(a);
    }

    @PreDestroy
    @Profiling
    public void destroy(){
        System.out.println("В destroy методе");
    }

    @Override
    @Profiling
    public String waitString() {
        try {
            Thread.sleep(500);
            StringBuilder stringBuilder = new StringBuilder("Генерирую");
            Thread.sleep(500);
            stringBuilder.append(" строку");
            Thread.sleep(500);
            stringBuilder.append("!");
            return stringBuilder.toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Ошибка";
    }


    @Override
    @Profiling
    public int count() {
        int count = 0;
        for (int i = 0; i < 100000; i++) {
            count += i;
        }
        return count;
    }

    @Override
    @Profiling
    public void threads() {
        for (int i = 0; i < 25; i++) {
            new Thread(() -> {
                while (isRun) {
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
            isRun = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
