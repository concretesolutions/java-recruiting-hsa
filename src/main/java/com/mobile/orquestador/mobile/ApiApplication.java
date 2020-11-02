package com.mobile.orquestador.mobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.mobile.orquestador.mobile" })
@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		Class<?>[] configClasses = { ApiApplication.class,  SwaggerConfiguracion.class};
		SpringApplication.run(configClasses, args);
	}

}
