package com.accenture.pruebamanuel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Clase que se encarga de la configuracion del Swagger.
 * 
 * @author Manuel Jimenez.
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

	/**
	 * indica el package que abarca la documentacion.
	 * 
	 * @return Docket
	 */
	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.accenture.pruebamanuel.controller"))
				.paths(PathSelectors.regex("/.*")).build().apiInfo(apiEndPointsInfo());
	}

	/**
	 * Indica la descripcion de la api y a quien contactar.
	 * 
	 * @return ApiInfo
	 */
	private ApiInfo apiEndPointsInfo() {

		return new ApiInfoBuilder().title("PRUEBA ACCENTURE API REST")
				.description("Proyecto que permite la obtenecion de cupones y categorias")
				.contact(new Contact("Manuel Jimenez", "https://www.accenture.com/cl-es",
						"jimeneznavarretemanuel@gmail.com"))
				.version("1.0.0").build();
	}
}