package com.accenture.concrete.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.accenture.concrete.mocker.CouponResponseMocker;
import com.accenture.concrete.response.CouponResponse;

public class CouponTest {

	@Test
	@DisplayName("coupon is expired")
	void couponExpired() {
		Coupon expiredCoupon = new Coupon(CouponResponseMocker.getRandomCoupon(true));
		assertThat(expiredCoupon.isExpired()).isTrue();
	}
	
	@Test
	@DisplayName("coupon is not expired")
	void couponNotExpired() {
		Coupon expiredCoupon = new Coupon(CouponResponseMocker.getRandomCoupon(false));
		assertThat(expiredCoupon.isExpired()).isFalse();
	}
	
}
