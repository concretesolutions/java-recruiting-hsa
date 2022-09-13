package com.accenture.concrete.service;

import java.util.ArrayList;
import java.util.List;

import com.accenture.concrete.domain.Coupon;
import com.accenture.concrete.domain.CouponAPI;
import com.accenture.concrete.mocker.CouponResponseMocker;

public class CouponServiceMock implements CouponAPI{

	private List<Coupon> coupons;
	
	@Override
	public List<Coupon> findAll() {
		return coupons;
	}
	
	public void setAllExpired(int sizeOfArray) {
		coupons = new ArrayList<>();
		for (int i = 0; i < sizeOfArray; i++) {
			coupons.add(new Coupon(CouponResponseMocker.getRandomCoupon(true)));
		}
	}
	
	public void setAllNonExpired(int sizeOfArray) {
		coupons = new ArrayList<>();
		for (int i = 0; i < sizeOfArray; i++) {
			coupons.add(new Coupon(CouponResponseMocker.getRandomCoupon(false)));
		}
	}
	
}
