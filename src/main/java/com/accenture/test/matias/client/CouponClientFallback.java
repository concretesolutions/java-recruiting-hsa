package com.accenture.test.matias.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.accenture.test.matias.model.Coupon;

@Component
public class CouponClientFallback implements CouponClient {
	
	@Override
	public ResponseEntity<List<Coupon>> getTopCoupons() {
		List<Coupon> list = new ArrayList<Coupon>();
		Coupon coupon = new Coupon();
		coupon.setDescription("description test");
		coupon.setExpiresAt("expiresat test");
		coupon.setId("id test");
		coupon.setImage("image test");
		coupon.setSeller("seller test");
		list.add(coupon);
		return new ResponseEntity<List<Coupon>>(list, HttpStatus.OK);
	}

}
