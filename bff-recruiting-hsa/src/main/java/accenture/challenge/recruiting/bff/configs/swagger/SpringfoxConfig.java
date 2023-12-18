package accenture.challenge.recruiting.bff.configs.swagger;

import accenture.challenge.recruiting.bff.configs.properties.SwaggerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static java.util.List.of;
import static springfox.documentation.builders.PathSelectors.any;
import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

@Configuration
public class SpringfoxConfig {

    @Autowired
    private SwaggerProperties swaggerProperties;

    /**
     * Basic Swagger configuration
     *
     * @return {@link Docket} Swagger configuration
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(withClassAnnotation(RestController.class))
                .paths(any())
                .build()
                .apiInfo(getApiInfo())
                .enable(swaggerProperties.isEnabled())
                .useDefaultResponseMessages(false);
    }

    /**
     * Sets the API information for Swagger UI
     *
     * @return {@link ApiInfo} API Information
     */
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                swaggerProperties.getName(),
                swaggerProperties.getDescription(),
                swaggerProperties.getVersion(),
                null,
                new Contact(swaggerProperties.getContact().getName(), null, swaggerProperties.getContact().getMail()),
                null,
                null,
                of()
        );
    }
}