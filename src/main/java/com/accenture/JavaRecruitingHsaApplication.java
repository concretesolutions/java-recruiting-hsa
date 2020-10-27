package com.accenture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "com.accenture" })
public class JavaRecruitingHsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaRecruitingHsaApplication.class, args);
	}

	@Bean
	public Docket usersApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("java-recruiting-hsa").apiInfo(usersApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.accenture.controller")).build()
				.useDefaultResponseMessages(false);
	}

	private ApiInfo usersApiInfo() {
		return new ApiInfoBuilder().title("Desafío accenture").version("1.0").build();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
