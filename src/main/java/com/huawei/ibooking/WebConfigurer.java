package com.huawei.ibooking;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);

        registry.addMapping("/**")
                .allowCredentials(false)
                .allowedOrigins("*")
                .allowedMethods("POST", "PUT", "OPTIONS", "DELETE", "GET")
                .allowedHeaders("*")
                .maxAge(3600);
    }
}
