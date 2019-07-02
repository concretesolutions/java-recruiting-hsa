package com.consultas.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultas.demo.dto.CategoryResponse;
import com.consultas.demo.dto.CouponResponse;
import com.consultas.demo.service.CouponService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/coupon")
public class CouponController {
	
	@Autowired
	private CouponService couponService;
	
	@ApiOperation(value = "Obtiene los cupones validos", response = CategoryResponse.class)
	@GetMapping(value = "/getValidCoupons")
    public List<CouponResponse> getValidCoupons() {

        return couponService.getValidCoupons();
    }
}
