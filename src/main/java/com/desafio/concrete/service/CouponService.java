package com.desafio.concrete.service;

import java.util.List;

import com.desafio.concrete.model.CouponResponse;

public interface CouponService {

	List<CouponResponse> getValidCoupons();

}
