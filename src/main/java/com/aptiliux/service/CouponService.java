package com.aptiliux.service;

import java.util.List;

import com.aptiliux.dto.coupon.CouponDTO;

public interface CouponService {

	List<CouponDTO> getNonExpiredCoupons();

	List<CouponDTO> getAllCoupons();


}
