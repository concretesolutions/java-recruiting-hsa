package cl.accenture.bff.categoriescoupons.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/*
 * Copyright (c) 2023 Boris Molina
 */
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
