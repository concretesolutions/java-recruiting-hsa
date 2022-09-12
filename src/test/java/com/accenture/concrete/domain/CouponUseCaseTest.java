package com.accenture.concrete.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.accenture.concrete.service.CouponServiceMock;

public class CouponUseCaseTest {

	@Test
	@DisplayName("should return more than one not expired coupon")
	void shouldNotReturnEmptyList() {
		
		CouponServiceMock mock = new CouponServiceMock();
		mock.setAllNonExpired(10);
		
		CouponUseCase couponUseCase = new CouponUseCase( mock );
		
		assertThat(couponUseCase.getNotExpiredCoupons()).isNotEmpty();
		
	}
	
	@Test
	@DisplayName("should not return coupons")
	void shouldReturnEmptyList() {
		
		CouponServiceMock mock = new CouponServiceMock();
		mock.setAllExpired(10);
		
		CouponUseCase couponUseCase = new CouponUseCase( mock );
		
		assertThat(couponUseCase.getNotExpiredCoupons()).isEmpty();
		
	}
	
}
