package com.concrete.javarecruitinghsa;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class JavaRecruitingHsaApplicationSwagger {

	@Value("${desafio.swagger.titulo}")
	private String titulo;

	@Value("${desafio.swagger.descripcion}")
	private String descripcion;
	
	@Bean
	public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.ignoredParameterTypes(CompletableFuture.class)
				.select()                                  
				.apis(RequestHandlerSelectors.basePackage("com.concrete.javarecruitinghsa.restcontroller"))              
				.paths(PathSelectors.any()) 
				.build().apiInfo(apiInfo());                                           
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(titulo)
				.description(descripcion)
				.contact( new Contact("Emilio", "fake.cl", "fake@fake.cl")).build();
	}
}
