package com.accenture.concrete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

import com.accenture.concrete.properties.CategoryProperties;
import com.accenture.concrete.properties.CorsProperties;
import com.accenture.concrete.properties.CouponProperties;

@EnableCaching
@SpringBootApplication
@EnableConfigurationProperties({
	CouponProperties.class,
	CorsProperties.class,
	CategoryProperties.class
})
public class ConcreteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcreteApplication.class, args);
	}

}
