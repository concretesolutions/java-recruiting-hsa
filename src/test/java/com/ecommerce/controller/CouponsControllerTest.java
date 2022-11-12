package com.ecommerce.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.service.CouponsService;

@SpringBootTest
class CouponsControllerTest {
	
	@Autowired
	private CouponsService service;

	@Test
	void testGetCouponsNotExpired() {
		assertThat(service.getCouponsNotExpired()).isNotNull();
	}

}
