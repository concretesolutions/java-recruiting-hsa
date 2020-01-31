package cl.accenture.concrete.feing.api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Request;


@Configuration
public class CategoriesConfiguration {
	
	@Value("${feign.categori.client.connectTimeout}")
	private int connectTimeout;

	@Value("${feign.categori.client.readTimeOut}")
	private int readTimeout;

	@Bean
	public Request.Options requestCategoriesOptions() {
		return new Request.Options(connectTimeout, readTimeout);
	}
}
