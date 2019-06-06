package com.concrete.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.concrete.challenge.apis.CategoryApi;
import com.concrete.challenge.apis.CouponApi;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableFeignClients
@SpringBootApplication
@EnableSwagger2
public class ConcretechallengeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac = SpringApplication.run(ConcretechallengeApplication.class, args);
		CouponApi ca = ac.getBean(CouponApi.class);
		System.out.println(ca.connect());
		CategoryApi catApi = ac.getBean(CategoryApi.class);
		System.out.println(catApi.connect());
	}
	
	@Bean
    public Docket challengeApi() {
       return new Docket(DocumentationType.SWAGGER_2).select()
         .apis(RequestHandlerSelectors.basePackage("com.concrete.challenge")).build()
         .apiInfo(endpointsApiInfo());
    }
	
	private ApiInfo endpointsApiInfo() {
        return new ApiInfoBuilder().title("Challenge")
            .description("Concrete REST API")
            .contact(new Contact("Jonnathan Osores", null,"j.osores.escalona@accenture.com"))
            .version("1.0.0")
            .build();
    }

}
