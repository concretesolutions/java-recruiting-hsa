package com.concrete.challenge.client.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConfigurationProperties
@EnableConfigurationProperties
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientConfiguration {

    @Value("${url.get-categories}")
    private String categoriesUrl;
    @Value("${url.get-coupons}")
    private String couponsUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
