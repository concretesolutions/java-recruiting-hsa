package com.consultas.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
@EnableCaching
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
public class TestMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestMsApplication.class, args);
	}

}
