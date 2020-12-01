package com.accenture.pruebamanuel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@EnableFeignClients
@SpringBootApplication
public class PruebamanuelApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebamanuelApplication.class, args);
	}

	@GetMapping("/health")
	public ResponseEntity<Boolean> getHealtCheck() {
		log.debug("health");
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}
}
