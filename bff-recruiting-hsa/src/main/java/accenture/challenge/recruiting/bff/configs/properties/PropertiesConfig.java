package accenture.challenge.recruiting.bff.configs.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:application.properties")
})
public class PropertiesConfig {

    @Bean
    @ConfigurationProperties(prefix = "swagger")
    public SwaggerProperties swaggerProperties() {
        return new SwaggerProperties();
    }

}