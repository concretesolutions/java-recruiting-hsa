package com.accenture.concrete.domain;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CouponUseCase {

	private static final Logger LOG = LogManager.getLogger(CouponUseCase.class);
	
	private CouponAPI api;
	
	public CouponUseCase(CouponAPI api) {
		this.api = api;
	}
	
	public List<Coupon> getNotExpiredCoupons(){
		
		List<Coupon> response = api.findAll();
		
		List<Coupon> notExpiredCoupons = response.stream()
				.filter(coupon -> !coupon.isExpired())
				.toList();
		
		if(LOG.isDebugEnabled()) {
			LOG.debug(notExpiredCoupons);
		}
		
		return notExpiredCoupons;
	}
	
}
