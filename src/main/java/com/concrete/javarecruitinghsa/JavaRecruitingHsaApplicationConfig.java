package com.concrete.javarecruitinghsa;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.Decoder;

@Configuration
public class JavaRecruitingHsaApplicationConfig {

	@Bean
	public Decoder feignDecoder() {
		return new SpringDecoder((HttpMessageConverters::new));
	}
	
}
