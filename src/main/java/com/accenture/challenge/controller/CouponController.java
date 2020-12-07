package com.accenture.challenge.controller;

import java.util.List;
/*
import org.springframework.web.bind.annotation.DeleteMapping;
*/
import org.springframework.web.bind.annotation.GetMapping;
/*
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

import com.accenture.challenge.service.CouponService;
import com.accenture.challenge.mapper.models.Coupon;

@RestController
public class CouponController {

   @Autowired
   private CouponService couponService;

   @GetMapping("/coupons/all")
   public String getCouponstList() {
      List<Coupon> coupons = couponService.getAll();

      String jsonObject = new Gson().toJson(coupons);
      //Object objetoJson = new Gson()fromJson(jsonObject, Object.class);

      return jsonObject;
   }
}
