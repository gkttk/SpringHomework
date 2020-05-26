package com.github.gkttk.injectBeans47;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanSetterInject {
    @Value("Bean Setter Inject")
    private String name;


    public String getName() {
        return name;
    }
}
