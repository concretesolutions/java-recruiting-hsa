package com.accenture.pruebamanuel.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.accenture.pruebamanuel.model.Cupon;

@FeignClient(name = "coupon-api", url = "https://cs-hsa-api-coupons.herokuapp.com")
public interface CouponsClient {

	/**
	 * Method that gets the coupons from the api..
	 * 
	 * @return Categories.
	 */
	@GetMapping("/coupons")
	public ResponseEntity<List<Cupon>> getCoupons();
}
