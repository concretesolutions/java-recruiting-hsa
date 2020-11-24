package com.accenture.javarecruiting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JavaRecruitingApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaRecruitingApplication.class, args);
    }

}
