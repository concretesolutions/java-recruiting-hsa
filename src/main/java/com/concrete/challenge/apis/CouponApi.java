package com.concrete.challenge.apis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import com.concrete.challenge.models.CouponResponse;

@FeignClient(url="https://cs-hsa-api-coupons.herokuapp.com",name="COUPON")
public interface CouponApi {
	
	@GetMapping("/coupons")
	public List<CouponResponse> getCoupons();
	
	public default String connect() {
		return "Api coupons ok!";
	}
}
