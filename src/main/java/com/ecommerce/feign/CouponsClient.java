package com.ecommerce.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.dto.CouponsDto;
import com.ecommerce.feign.fallback.CouponsClientFallback;

import feign.Headers;

@FeignClient(name = "${coupons.api.name}", url = "${coupons.api.url}", fallback = CouponsClientFallback.class)
public interface CouponsClient {
	
	@GetMapping("/coupons")
	@Headers("accept: application/json")
    List<CouponsDto> getAll();	

}
