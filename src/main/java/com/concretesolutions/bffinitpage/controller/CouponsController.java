/**
 * Backend Code Challenge - forked from concretesolutions/java-recruiting-hsa
 * 
 * Author: Jorge Leiva
 * Mail: jorgeleiva.17@gmail.com
 */
package com.concretesolutions.bffinitpage.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.concretesolutions.bffinitpage.entities.Coupon;
import com.concretesolutions.bffinitpage.service.CouponsService;

@RestController
@RequestMapping("/bff/v1/coupons")
public class CouponsController {

  CouponsService couponService;

  @Autowired
  public CouponsController(CouponsService couponService) {
    this.couponService = couponService;
  }

  @GetMapping()
  public CompletableFuture<List<Coupon>> notExpired() {
    return couponService.getNotExpired();
  }
}
