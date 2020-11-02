package com.example.javarecruitinghsa.controller;

import com.example.javarecruitinghsa.dto.CategoriaDTO;
import com.example.javarecruitinghsa.pojo.Coupon;
import com.example.javarecruitinghsa.service.CategoriaService;
import com.example.javarecruitinghsa.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CouponController {

    @Autowired
    private CouponService couponService;

    @RequestMapping(value = "/coupon/aviable", method = RequestMethod.GET)
    public ResponseEntity<List<Coupon>> aviable() {
        Optional<List<Coupon>> top = couponService.aviable();
        if (top.isPresent()) return ResponseEntity.of(top);
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
