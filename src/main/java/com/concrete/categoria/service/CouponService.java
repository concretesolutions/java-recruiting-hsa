package com.concrete.categoria.service;

import java.util.Collection;

import com.concrete.categoria.dto.CouponDTO;

public interface CouponService {

	public Collection<CouponDTO> getCoupons();
	public Collection<CouponDTO> getNotExpiredCoupons();
	
}
