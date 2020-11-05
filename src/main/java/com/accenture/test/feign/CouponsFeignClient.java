package com.accenture.test.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.accenture.test.dto.Coupons;

import feign.Headers;

@FeignClient(url = "${apis.service.coupons}", name = "${apis.service.nameCoupons}")
public interface CouponsFeignClient {
	
	@GetMapping("/coupons")
	@Headers("accept: application/json")
	public List<Coupons> getCoupons();
}
