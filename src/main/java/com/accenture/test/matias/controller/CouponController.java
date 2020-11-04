package com.accenture.test.matias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.test.matias.model.Coupon;
import com.accenture.test.matias.service.CouponService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/coupon")
public class CouponController {

	/**
	 * Service that handle the coupons.
	 */
	@Autowired
	private CouponService couponService;

	@GetMapping("/top/{limit}")
	private ResponseEntity<List<Coupon>> getTopCoupons(@PathVariable(value = "limit") Integer limit) {
		
		log.info("[CouponController][getTopCoupons][{}] Inicio.", limit);
		List<Coupon> response = couponService.getTopCoupons(limit);
		log.info("[CouponController][getTopCoupons][{}][{}] Fin.", response, limit);
		
		return new ResponseEntity<List<Coupon>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/not-top/{limit}")
	private ResponseEntity<List<Coupon>> getNotTopCoupons(@PathVariable(value = "limit") Integer limit) {
		
		log.info("[CouponController][getNotTopCoupons][{}] Inicio.", limit);
		List<Coupon> response = couponService.getNotTopCoupons(limit);
		log.info("[CouponController][getNotTopCoupons][{}][{}] Fin.", response, limit);
		
		return new ResponseEntity<List<Coupon>>(response, HttpStatus.OK);
	}
}
