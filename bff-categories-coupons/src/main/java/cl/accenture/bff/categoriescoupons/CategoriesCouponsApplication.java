package cl.accenture.bff.categoriescoupons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.retry.annotation.EnableRetry;

/*
 * Copyright (c) 2023 Boris Molina
 */
@EnableFeignClients
@EnableRetry
@PropertySource("classpath:retryConfig.properties")
@SpringBootApplication
public class CategoriesCouponsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoriesCouponsApplication.class, args);
	}

}
