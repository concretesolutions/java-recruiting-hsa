package com.accenture.test.matias.service;

import java.util.List;

import com.accenture.test.matias.model.Coupon;

public interface CouponService {

	List<Coupon> getTopCoupons(int limit);

	List<Coupon> getNotTopCoupons(int limit);

}
