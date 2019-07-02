package com.consultas.demo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.consultas.demo.dto.CategoryResponse;
import com.consultas.demo.dto.CouponResponse;
import com.consultas.demo.dto.Post;

@FeignClient(url="https://cs-hsa-api-coupons.herokuapp.com",name="COUPON")
public interface CouponsServiceRestClient {
	
	@GetMapping("/coupons")
	public List<CouponResponse> getCoupons();
	
}
