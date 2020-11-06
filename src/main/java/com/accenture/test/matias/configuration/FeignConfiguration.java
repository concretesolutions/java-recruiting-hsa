package com.accenture.test.matias.configuration;

import org.springframework.context.annotation.Bean;

import feign.Logger;
import feign.Retryer;

public class FeignConfiguration {

	@Bean
	public Logger.Level configureLogLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	public Retryer retryer() {
		return new Retryer.Default(4000, 8000, 1);
	}
}
