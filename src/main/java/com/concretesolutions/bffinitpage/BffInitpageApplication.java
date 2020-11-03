/**
 * Backend Code Challenge - forked from concretesolutions/java-recruiting-hsa
 * 
 * Author: Jorge Leiva
 * Mail: jorgeleiva.17@gmail.com
 */
package com.concretesolutions.bffinitpage;

import java.time.Duration;
import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAsync
public class BffInitpageApplication {

  static final int TIMEOUT = 5000;

  public static void main(String[] args) {
    SpringApplication.run(BffInitpageApplication.class, args);
  }

  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(TIMEOUT))
        .setReadTimeout(Duration.ofMillis(TIMEOUT)).build();
  }

  @Bean
  public Executor taskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(2);
    executor.setMaxPoolSize(2);
    executor.setQueueCapacity(500);
    executor.setThreadNamePrefix("BffInitpage-");
    executor.initialize();
    return executor;
  }

}
