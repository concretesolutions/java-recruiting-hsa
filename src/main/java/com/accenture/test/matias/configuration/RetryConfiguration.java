package com.accenture.test.matias.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalancedRetryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.BackOffPolicy;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;

@Configuration
public class RetryConfiguration {

	@Bean
	LoadBalancedRetryFactory retryFactory() {
		return new LoadBalancedRetryFactory() {
			@Override
			public BackOffPolicy createBackOffPolicy(String service) {
				return new ExponentialBackOffPolicy();
			}
		};
	}

}
