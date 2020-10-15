package cl.concretesolutions.mobileapp.api.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.concretesolutions.mobileapp.api.coupon.CouponDto;
import cl.concretesolutions.mobileapp.api.coupon.service.CouponService;

@RestController
public class CouponController {
	
	@Autowired
	private CouponService service;

	@Async
	@GetMapping("/coupons")
	public List<CouponDto> getCoupons() {
		return service.getCoupons();
	}
}
