package com.accenture.test.matias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableFeignClients
@EnableHystrix
@EnableCircuitBreaker
public class JavatestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavatestApplication.class, args);
	}

}
