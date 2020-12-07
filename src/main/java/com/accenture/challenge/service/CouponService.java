package com.accenture.challenge.service;

import java.util.List;
/*
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
*/

import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.challenge.mapper.interfaces.CouponClientInterface;
import com.accenture.challenge.mapper.models.Coupon;


public class CouponService {
    
    @Autowired
	private CouponClientInterface couponClient;

	public List<Coupon> getAll() {
		List<Coupon> coupons = couponClient.getAll();
		return coupons;
	}
}
