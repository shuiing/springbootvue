package com.shui.cluoudzuul;

import com.didispace.swagger.butler.EnableSwaggerButler;
import com.shui.cluoudzuul.config.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwaggerButler
public class CluoudzuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CluoudzuulApplication.class, args);
    }


    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
