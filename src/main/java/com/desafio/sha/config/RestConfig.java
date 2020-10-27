package com.desafio.sha.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
	
	@Value("${rest.client.connectTimeout}")
	private String connectTimeout;

	@Value("${rest.client.readTimeOut}")
	private String readTimeout;
	@Bean
	public RestTemplate getRestTemplate() {
		// proxy support

		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(Integer.parseInt(connectTimeout));
		factory.setReadTimeout(Integer.parseInt(readTimeout));

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(factory);
		return restTemplate;
	}
}
