package com.concrete.javarecruitinghsa.restcontroller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.concrete.javarecruitinghsa.dto.coupon.Coupon;
import com.concrete.javarecruitinghsa.service.CouponService;

@SpringBootTest
@AutoConfigureMockMvc
public class CouponRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CouponService couponService;
	
	
//	@Test
//	public void getCouponsNotFound() throws Exception {
//		List<Coupon> coupons = null;
//		
//		when(couponService.getUnExpiredCoupon()).thenReturn(coupons);
//		mockMvc.perform( MockMvcRequestBuilders.get("/v1/coupon/carrousel")).andExpect( status().isNotFound() );	
//	}
	
	@Test
	public void getCouponsOk() throws Exception {
		List<Coupon> coupons = new ArrayList<Coupon>();
		coupons.add(new Coupon());
		
		when(couponService.getUnExpiredCoupon()).thenReturn(coupons);
		mockMvc.perform( MockMvcRequestBuilders.get("/v1/coupon/carrousel")).andExpect( status().isOk() );	
	}
	
}
