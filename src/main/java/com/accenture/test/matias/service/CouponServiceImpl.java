package com.accenture.test.matias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.test.matias.client.CouponClient;
import com.accenture.test.matias.model.Coupon;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponClient couponClient;

	@Override
	public List<Coupon> getCoupons() {
		List<Coupon> topCoupons = couponClient.getTopCoupons().getBody();
		return topCoupons;
	}

}
