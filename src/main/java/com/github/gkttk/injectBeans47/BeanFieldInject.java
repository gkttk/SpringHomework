package com.github.gkttk.injectBeans47;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanFieldInject {
    @Value("Bean Field Inject")
    private String name;

    public String getName() {
        return name;
    }
}
