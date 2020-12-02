package com.accenture.pruebamanuel.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.accenture.pruebamanuel.client.CouponsClient;
import com.accenture.pruebamanuel.model.Cupon;

public class CouponServiceTest {

	@InjectMocks
	private CouponService cuponServices;

	@Mock
	private CouponsClient couponClient;

	@BeforeEach
	public void init() {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getCouponOk() {

		List<Cupon> cuponApi = getCupons();

		ResponseEntity<List<Cupon>> response = new ResponseEntity<List<Cupon>>(cuponApi, HttpStatus.OK);
		Mockito.when(couponClient.getCoupons()).thenReturn(response);
		List<Cupon> coupons = cuponServices.getCoupon();

		assertNotNull("no puede ser null", coupons);
	}

	private List<Cupon> getCupons() {
		Cupon cupon1 = craeteCoupon("COUPON_1", "50% Discount", "Crazy Seller",
				"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2045-12-01");
		Cupon cupon2 = craeteCoupon("COUPON_3", "100% Discount", "Old Seller",
				"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2018-10-01");
		return Stream.of(cupon1, cupon2).collect(Collectors.toList());
	}

	private Cupon craeteCoupon(String id, String description, String seller, String image, String expiresAt) {

		Cupon cupon = new Cupon();
		cupon.setId(id);
		cupon.setDescription(description);
		cupon.setSeller(seller);
		cupon.setImage(image);
		cupon.setExpiresAt(expiresAt);
		return cupon;
	}

}
