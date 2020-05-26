package com.github.gkttk.injectBean89.apiBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanMarkerImpl1 implements BeanMarker {
    @Value("Bean Marker Impl 1")
    private String name;

    public String getName() {
        return name;
    }
}
