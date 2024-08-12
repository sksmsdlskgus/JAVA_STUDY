package com.ohgiraffers.chap01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Value("${test.value}")
    public String value;

    @Value("${username}")
    public String username;

    @Bean
    public Object propertyReadTest(){
        System.out.println("value = " + value);
        System.out.println("username = " + username);

        return new Object();
    }

}
