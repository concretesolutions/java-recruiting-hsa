package com.ecommerce.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.service.CategoriesService;

@SpringBootTest
class CategoriesControllerTest {
	
	@Autowired
	private CategoriesService service;

	@Test
	void testGetTopFive() {
		assertThat(service.getTopFive()).isNotNull();
	}
	
	@Test
	void testGetExceptTopFive() {
		assertThat(service.getExceptTopFive()).isNotNull();
	}

}
