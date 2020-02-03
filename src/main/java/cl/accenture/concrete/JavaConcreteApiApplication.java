package cl.accenture.concrete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author c.leon.palacios
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
public class JavaConcreteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaConcreteApiApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("cl.accenture.concrete")).build();
	}

}
