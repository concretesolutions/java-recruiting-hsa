package com.accenture.test.matias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.test.matias.model.Coupon;
import com.accenture.test.matias.service.CouponService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/coupons")
public class CouponController {

	/**
	 * Service that handle the coupons.
	 */
	@Autowired
	private CouponService couponService;

	@GetMapping("")
	public ResponseEntity<List<Coupon>> getCoupons() {

		log.info("[CouponController][getTopCoupons] Inicio.");
		List<Coupon> response = couponService.getCoupons();
		log.info("[CouponController][getTopCoupons][{}] Fin.", response);

		return new ResponseEntity<List<Coupon>>(response, HttpStatus.OK);
	}
}
