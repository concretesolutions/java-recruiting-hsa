package com.concrete.javarecruitinghsa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.concrete.javarecruitinghsa.dto.coupon.Coupon;
import com.concrete.javarecruitinghsa.restclient.CouponRestClient;

@SpringBootTest
public class CouponServiceTest {

	@InjectMocks
	private CouponService couponService;
	@Mock
	private CouponRestClient couponRestClient;
	
	List<Coupon> coupons = new ArrayList<Coupon>();
	
	@BeforeEach
	public void init(){
		
		coupons.add(Coupon.builder()
							.id("COUPON_2")
							.description("5% Discount")
							.seller("The Seller")
							.image("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg")
							.expiresAt(LocalDate.of(2042, 12, 25))
							.build());
		
		coupons.add(Coupon.builder()
							.id("COUPON_3")
							.description("100% Discount")
							.seller("Old Seller")
							.image("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg")
							.expiresAt(LocalDate.of(2018, 10, 01))
							.build());
	}
	
	@Test
    public void getUnExpiredCouponTest() throws Exception {		
		when(couponRestClient.getCoupons()).thenReturn(coupons);		
		assertEquals(1, couponService.getUnExpiredCoupon().size());
    }
	
}
