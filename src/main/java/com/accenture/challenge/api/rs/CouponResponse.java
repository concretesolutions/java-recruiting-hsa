package com.accenture.challenge.api.rs;

import java.util.List;

import com.accenture.challenge.api.models.Coupon;

import lombok.Data;

@Data
public class CouponResponse {
	
	private Status serviceStatus;
	private List<Coupon> coupons;
	private String status;

}
