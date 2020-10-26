package cl.mobile.bff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.mobile.bff.domain.CouponClientResponse;
import cl.mobile.bff.service.interfaces.CouponService;

@RestController
@RequestMapping(value = "/bff/mobile/api/coupon")
public class CouponController {
	
	@Autowired
	private CouponService couponService;
	
	@GetMapping(value = "/notexpider")
	public List<CouponClientResponse> getCouponNotExpiderd() {
		return couponService.getCouponNotExpiderd();
	}

}
