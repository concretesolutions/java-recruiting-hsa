package com.accenture.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PruebaAccentureApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaAccentureApplication.class, args);
    }

}
