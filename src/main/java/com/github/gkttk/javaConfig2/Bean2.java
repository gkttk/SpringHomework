package com.github.gkttk.javaConfig2;

public class Bean2 {
    private String name;
    private RefBean2 ref;

    public Bean2(String name, RefBean2 ref) {
        this.name = name;
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RefBean2 getRef() {
        return ref;
    }

    public void setRef(RefBean2 ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return name + " " + ref;

    }
}
