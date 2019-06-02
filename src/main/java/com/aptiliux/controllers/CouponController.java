package com.aptiliux.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aptiliux.dto.coupon.CouponDTO;
import com.aptiliux.dto.json.view.Views;
import com.aptiliux.service.CouponService;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @CrossOrigin(origins = "*")
    @ApiOperation(value = "Return available coupons")
    @GetMapping(value = "/coupons/available", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CouponDTO>> getNonExpiredCoupons() {
        return new ResponseEntity<>(couponService.getNonExpiredCoupons(), HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "*")
    @ApiOperation(value = "Return available coupons")
    @GetMapping(value = "/mobile/coupons/available", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(Views.Mobile.class) 
    public ResponseEntity<List<CouponDTO>> getNonExpiredMobileCoupons() {
        return new ResponseEntity<>(couponService.getNonExpiredCoupons(), HttpStatus.OK);
    }

}
