package com.cp.sb.base.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class A {

    @Bean
    public IDemoService demoService(){
        return new DemoServiceImpl();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
