package com.concrete.challenge.controller;

import com.concrete.challenge.model.Coupon;
import com.concrete.challenge.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping("/coupons")
    public List<Coupon> getCouponsNotExpired(){
        return couponService.findCouponsNotExpired();
    }
}
