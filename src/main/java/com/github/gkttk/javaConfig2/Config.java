package com.github.gkttk.javaConfig2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.github.gkttk.javaConfig2.componentScan")
public class Config {

    @Bean
    public RefBean2 refBean2(){
        return new RefBean2(200);
    }

    @Bean
    public Bean2 bean2(){
        return new Bean2("Бин2", refBean2());
    }

}
