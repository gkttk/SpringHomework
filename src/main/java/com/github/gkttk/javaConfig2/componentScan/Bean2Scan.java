package com.github.gkttk.javaConfig2.componentScan;

import org.springframework.stereotype.Component;

@Component
public class Bean2Scan {
    private boolean isTrue = true;

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }
}
