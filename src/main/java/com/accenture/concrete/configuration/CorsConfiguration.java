package com.accenture.concrete.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.accenture.concrete.properties.CorsProperties;

@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer {

	private CorsProperties cors;
	
	@Autowired
	public CorsConfiguration(CorsProperties cors) {
		this.cors = cors;
	}
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	String[] headers = new String[cors.allowsHeaders().size()];
    	String[] methods = new String[cors.allowsMethods().size()];
    	String[] origins = new String[cors.allowsOrigins().size()];
    	
        registry
        	.addMapping("/**")
        	.allowedHeaders(cors.allowsHeaders().toArray(headers))
        	.allowedMethods(cors.allowsMethods().toArray(methods))
        	.allowedOrigins(cors.allowsOrigins().toArray(origins));
    }
    
}