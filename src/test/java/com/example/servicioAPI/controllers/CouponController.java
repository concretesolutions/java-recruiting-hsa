package com.example.servicioAPI.controllers;

import com.example.servicioAPI.model.Coupon;
import com.example.servicioAPI.services.CategoriasService;
import com.example.servicioAPI.services.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class CouponController {
    @Autowired
    CouponService couponService;

    @GetMapping("/nonexpired")
    public List<Coupon> coupon() throws ParseException {
         List<Coupon> listCoupon = this.couponService.consumirJSON();
        listCoupon = this.nonExpiredCoupons(listCoupon);
        return listCoupon;
    }
    private List<Coupon> nonExpiredCoupons(List<Coupon> listCoupon) throws ParseException {
        List<Coupon> nonExpiredCoupons = new ArrayList<Coupon>();

        for (Coupon cupon: listCoupon) {
            Date date =new SimpleDateFormat("yyyy-MM-dd").parse(cupon.getExpiresAt());
            if(date.compareTo(new Date())>0){
                nonExpiredCoupons.add(cupon);
            }
        }
        return nonExpiredCoupons;
    }
}
