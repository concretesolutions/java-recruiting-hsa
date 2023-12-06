package com.example.demo.config;


import com.example.demo.controller.handler.CustomErrorDecoder;
import com.example.demo.properties.PropertiesFeign;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder(new PropertiesFeign());
    }

}
