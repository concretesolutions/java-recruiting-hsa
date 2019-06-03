package com.concrete.challenge.controllers.web;

import com.concrete.challenge.bean.coupons.external.Coupon;
import com.concrete.challenge.controllers.base.BaseController;
import com.concrete.challenge.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponsController implements BaseController {

    @Autowired
    private CouponsService couponsService;

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Coupon>> getActiveCoupons() {

        List<Coupon> coupons = couponsService.getActiveCoupons();
        return new ResponseEntity<>(coupons, getResponseHeaders(), !coupons.isEmpty() ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
}
