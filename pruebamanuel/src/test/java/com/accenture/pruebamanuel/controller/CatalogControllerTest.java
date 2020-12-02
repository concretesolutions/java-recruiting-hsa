package com.accenture.pruebamanuel.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.accenture.pruebamanuel.model.Cupon;
import com.accenture.pruebamanuel.service.CategoryService;
import com.accenture.pruebamanuel.service.CouponService;

public class CatalogControllerTest {

	@InjectMocks
	private CatalogController controller;

	@Mock
	private CouponService cuponService;

	@Mock
	private CategoryService categoriService;

	@BeforeEach
	public void init() {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getCategories() {

		Cupon cupon = new Cupon();
		cupon.setDescription("50% Discount");
		cupon.setExpiresAt("2045-12-01");
		cupon.setId("COUPON_1");
		List<Cupon> cupones = new ArrayList<>();
		cupones.add(cupon);

		Mockito.when(cuponService.getCoupon()).thenReturn(cupones);
		ResponseEntity<List<Cupon>> response = controller.getCoupons();
		assertNotNull(response.getBody());
	}

}
