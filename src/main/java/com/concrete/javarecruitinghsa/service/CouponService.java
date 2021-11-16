package com.concrete.javarecruitinghsa.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concrete.javarecruitinghsa.dto.coupon.Coupon;
import com.concrete.javarecruitinghsa.restclient.CouponRestClient;

@Service
public class CouponService {

	@Autowired
	private CouponRestClient couponRestClient;

	public List<Coupon> getUnExpiredCoupon() {
		return couponRestClient.getCoupons()
				.stream()
				.filter(c -> !c.getExpiresAt().isBefore(LocalDate.now()) )
				.collect(Collectors.toList());
	}
}
