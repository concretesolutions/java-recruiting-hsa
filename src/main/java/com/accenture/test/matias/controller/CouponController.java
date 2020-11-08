package com.accenture.test.matias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.test.matias.model.Coupon;
import com.accenture.test.matias.service.CouponService;

import lombok.extern.log4j.Log4j2;

/**
 * Controller for Coupons.
 * 
 * @author Matias Gomez Arancibia.
 *
 */
@Log4j2
@RestController
@RequestMapping("/coupons")
public class CouponController {

    /**
     * Service that handle the coupons.
     */
    @Autowired
    private CouponService couponService;

    /**
     * Method that returns the coupons not expired.
     * 
     * @return Coupons not expired.
     */
    @GetMapping("/not-expired")
    public ResponseEntity<List<Coupon>> getCoupons() {

        log.info("[CouponController][getCoupons] Inicio.");
        List<Coupon> response = couponService.getNotExpiredCoupons();
        log.info("[CouponController][getCoupons][{}] Fin.", response);

        return new ResponseEntity<List<Coupon>>(response, HttpStatus.OK);
    }
}
