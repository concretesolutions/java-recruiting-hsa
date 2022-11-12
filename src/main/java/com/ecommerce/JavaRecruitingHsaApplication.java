package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Ecommerce API", version = "1.0", description = "Backend app ecommerce"))

public class JavaRecruitingHsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaRecruitingHsaApplication.class, args);
	}

}
