package com.github.gkttk.injectBeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanCounstructorInject {
    @Value("Bean Constructor Inject")
    private String name;

    public String getName() {
        return name;
    }
}
