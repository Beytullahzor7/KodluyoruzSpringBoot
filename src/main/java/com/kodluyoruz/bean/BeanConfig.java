package com.kodluyoruz.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "initialBeanMethod", destroyMethod = "destroyBeanMethod")
    @Scope("singleton")
    public BeanDto beanDto(){
        return BeanDto
                .builder()
                    .id(0L).beanName("bean Adi").beanData("bean Data")
                .build();
    }
}
