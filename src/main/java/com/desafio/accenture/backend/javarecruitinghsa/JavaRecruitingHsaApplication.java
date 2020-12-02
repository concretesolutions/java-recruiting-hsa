package com.desafio.accenture.backend.javarecruitinghsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JavaRecruitingHsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaRecruitingHsaApplication.class, args);
	}

}
