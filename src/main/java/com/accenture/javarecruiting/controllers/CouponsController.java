package com.accenture.javarecruiting.controllers;

import com.accenture.javarecruiting.dao.CouponsDAO;
import com.accenture.javarecruiting.dto.CouponsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CouponsController {

    @Autowired
    private CouponsDAO couponsDAO;

    @GetMapping("/coupons/valid")
    public List<CouponsDTO> getValidCoupons() {
        return couponsDAO.getValidCoupons();
    }

}
