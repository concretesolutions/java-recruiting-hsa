package com.desafio_concrete.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.desafio_concrete.api.dto.Coupon;

@FeignClient(url="https://cs-hsa-api-coupons.herokuapp.com", name="COUPONS")
public interface CouponClient {

	@GetMapping("/coupons")
	public List<Coupon> getCoupons();
	
}
