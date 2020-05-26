package com.github.gkttk.injectBeans47;

import com.github.gkttk.injectBeans47.apiBean.BeanMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Bean47 {

    @Autowired
    private BeanFieldInject beanFieldInject;   //инжект через поле(задание 4, тест 4)

    private BeanSetterInject beanSetterInject;   //инжект через сеттер(задание 5, тест 4)

    private BeanCounstructorInject beanCounstructorInject;  //инжект через конструктор(задание 6, тест 4)

    @Autowired
    @Qualifier("beanMarkerImpl1")
    private BeanMarker beanMarker1;        //инжект двух разных бинов с одним интерфейсом(задание 7, тест 4)
    @Autowired
    @Qualifier("beanMarkerImpl2")
    private BeanMarker beanMarker2;         // -//-//-//-//-//-


    public BeanMarker getBeanMarker1() {
        return beanMarker1;
    }

    public BeanMarker getBeanMarker2() {
        return beanMarker2;
    }

    @Autowired
    public Bean47(BeanCounstructorInject beanCounstructorInject) {
        this.beanCounstructorInject = beanCounstructorInject;
    }

    public BeanCounstructorInject getBeanCounstructorInject() {
        return beanCounstructorInject;
    }

    @Autowired
    public void setBeanSetterInject(BeanSetterInject beanSetterInject) {
        this.beanSetterInject = beanSetterInject;
    }

    public BeanSetterInject getBeanSetterInject() {
        return beanSetterInject;
    }


    public BeanFieldInject getBeanFieldInject() {
        return beanFieldInject;
    }

    public void setBeanFieldInject(BeanFieldInject beanFieldInject) {
        this.beanFieldInject = beanFieldInject;
    }
}
