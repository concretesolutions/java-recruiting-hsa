package com.desafio_concrete.api;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio_concrete.api.client.CouponClient;
import com.desafio_concrete.api.dto.Coupon;

@RestController
public class CouponController {
	
	@Autowired
	private CouponClient client_coupon;
	
	@Async
	@GetMapping("/getAllCoupons")
	public List<Coupon> getAllCoupons() {
		List<Coupon> coupons = client_coupon.getCoupons();
		LocalDate currentDay = LocalDate.now();
		return coupons.stream().filter(x -> x.getExpiresAt().isAfter(currentDay)).collect(Collectors.toList());
	}
	
	
}
