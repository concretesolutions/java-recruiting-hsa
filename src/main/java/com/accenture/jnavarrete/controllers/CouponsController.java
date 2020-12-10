package com.accenture.jnavarrete.controllers;

import com.accenture.jnavarrete.model.CouponsModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class CouponsController {

    @GetMapping("/coupons")
    public CouponsModel getAllCoupons() {
        return new CouponsModel();
    }

    @GetMapping("/unexpired-coupons")
    public CouponsModel getUnexpiredCoupons() {
        return new CouponsModel();
    }
}
