package com.concrete.javarecruitinghsa.restclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.concrete.javarecruitinghsa.dto.coupon.Coupon;

@FeignClient(name = "COUPON", url = "${desafio.url-api-coupon}")
public interface CouponRestClient {
	
	@GetMapping("/coupons")
	public List<Coupon> getCoupons();
	
}
