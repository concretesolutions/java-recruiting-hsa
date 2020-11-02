package com.mobile.orquestador.mobile;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguracion {

	@Bean
	public Docket usersApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.mobile.orquestador.mobile.controller")).build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Orquestador Mobile", "Desafio Concrete Solutions", "1.0.0", "Libre",
				new springfox.documentation.service.Contact("Johnny Troncoso", "", "dlive.johnny@gmail.com"),
				"API Orquestador Mobile", "", Collections.emptyList());
	}

}
