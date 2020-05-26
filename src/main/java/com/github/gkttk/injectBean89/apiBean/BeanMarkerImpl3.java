package com.github.gkttk.injectBean89.apiBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanMarkerImpl3 implements BeanMarker {
    @Value("Bean Marker Impl 3")
    private String name;

    public String getName() {
        return name;
    }
}
