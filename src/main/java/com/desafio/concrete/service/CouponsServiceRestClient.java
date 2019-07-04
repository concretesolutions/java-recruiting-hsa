package com.desafio.concrete.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.desafio.concrete.model.CouponResponse;

@FeignClient(url="https://cs-hsa-api-coupons.herokuapp.com",name="COUPON")
public interface CouponsServiceRestClient {
	
	@GetMapping("/coupons")
	public List<CouponResponse> getCoupons();
	
}
