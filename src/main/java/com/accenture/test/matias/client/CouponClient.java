package com.accenture.test.matias.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.accenture.test.matias.configuration.FeignConfiguration;
import com.accenture.test.matias.model.Coupon;

@FeignClient(name = "coupon-service", url = "https://cs-hsa-api-coupons.herokuapp.com", fallback = CouponClientFallback.class, configuration = FeignConfiguration.class)
public interface CouponClient {

	@GetMapping("/coupons")
	public ResponseEntity<List<Coupon>> getTopCoupons();

}
