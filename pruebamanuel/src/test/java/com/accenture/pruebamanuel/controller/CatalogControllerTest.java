package com.accenture.pruebamanuel.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.pruebamanuel.exception.ServiceUnavailableException;
import com.accenture.pruebamanuel.model.Cupon;
import com.accenture.pruebamanuel.service.CategoryService;
import com.accenture.pruebamanuel.service.CouponService;

@RunWith(SpringRunner.class)
public class CatalogControllerTest {

	@InjectMocks
	private CatalogController controller;

	@Mock
	private CouponService cuponService;

	@Mock
	private CategoryService categoriService;

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
		Assert.assertNotNull(response.getBody());
	}

	@Test(expected = ServiceUnavailableException.class)
	public void fallbackGetReportTest() {

		ServiceUnavailableException e = new ServiceUnavailableException();
		controller.fallbackGetListCoupon(e);
	}

}
