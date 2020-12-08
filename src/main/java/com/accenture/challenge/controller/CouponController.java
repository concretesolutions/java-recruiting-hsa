package com.accenture.challenge.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.accenture.challenge.mapper.Coupon;
import com.google.gson.Gson;

@RestController
public class CouponController {

   @Autowired
   RestTemplate restTemplate;

   @RequestMapping(value = "/api/all-coupons")
   public String getCouponsList() {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <String> entity = new HttpEntity<String>(headers);
      
	  return
		  restTemplate.exchange(
			  "https://cs-hsa-api-coupons.herokuapp.com/coupons", 
			  HttpMethod.GET, 
			  entity, 
			  String.class
			).getBody();
   }
   
   @RequestMapping(value = "/api/unexpired-coupons")
   public String getUnexpiredCouponstList() throws ParseException {
      String response    = this.getCouponsList();
      Coupon[] coupons   = new Gson().fromJson(response, Coupon[].class);

      ArrayList<Coupon> unexpired = new ArrayList<Coupon>();
      SimpleDateFormat sdformat   = new SimpleDateFormat("yyyy-MM-dd");
      
      Date sysDate = new Date();
      for (Coupon coupon : coupons) {
         Date dateCoupon = sdformat.parse(coupon.getExpiresAt());
         if(dateCoupon.after(sysDate)){
            unexpired.add(coupon);
         }
      }
      return new Gson().toJson(unexpired);
   }
}
