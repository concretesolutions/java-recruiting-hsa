package com.consultas.demo.service;

import java.util.List;

import com.consultas.demo.dto.CategoryResponse;
import com.consultas.demo.dto.CouponResponse;

public interface CouponService {

	List<CouponResponse> getValidCoupons();

}
