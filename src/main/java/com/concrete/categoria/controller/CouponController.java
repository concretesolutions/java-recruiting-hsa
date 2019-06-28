package com.concrete.categoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.concrete.categoria.service.CouponService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/cupon")
public class CouponController {
	
	@Autowired
	CouponService couponService;

	@RequestMapping(method = RequestMethod.GET, value = "listar/todo", produces = "application/json")
	public String getAll() {

		String json = new Gson().toJson(couponService.getCoupons());
		return json;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "listar/no-expirados", produces = "application/json")
	public String getNotExpired() {

		String json = new Gson().toJson(couponService.getNotExpiredCoupons());
		return json;
	}
}
