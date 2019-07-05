package cl.accenture.concrete.challenge.swagger;

import java.util.Collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig implements WebMvcConfigurer{
	
	// Logger
	private static final Log LOGGER = LogFactory.getLog(SpringFoxConfig.class);
	
	@Value("${swagger.rest.base.package}")
	private String basePackage;
	
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
  
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        LOGGER.info("Configure Forward to Swagger UI");
        registry.addRedirectViewController("/", "/swagger-ui.html");
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Java Concrete Challenge API", 
          "Api desarrollada en base a los requerimientos de Accenture Java Concrete Challenge.", 
          "API TOS",
          "", 
          new Contact("Patricio Perez", "", ""), 
          "License: Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
    }
}