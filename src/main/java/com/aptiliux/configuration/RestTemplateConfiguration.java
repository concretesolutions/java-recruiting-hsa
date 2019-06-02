package com.aptiliux.configuration;

import lombok.extern.log4j.Log4j2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Configuration
public class RestTemplateConfiguration {

	@Bean
	public RestTemplate getRestTemplate() {
    	return new RestTemplate();
	}
    
}

