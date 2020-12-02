package com.desafio.accenture.backend.javarecruitinghsa.controller;


import com.desafio.accenture.backend.javarecruitinghsa.dto.CouponsDTO;
import com.desafio.accenture.backend.javarecruitinghsa.exception.GenericException;
import com.desafio.accenture.backend.javarecruitinghsa.service.CouponsService;
import com.desafio.accenture.backend.javarecruitinghsa.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CuponesController {

    @Autowired
    CouponsService couponsService;




    @GetMapping(value = "/coupons")
    public ResponseEntity<List<CouponsDTO>> listaCoupons() {
        List<CouponsDTO> LstCoupons = null;
        try {
            LstCoupons = couponsService.getCarruselCupones();
            return new ResponseEntity<>(LstCoupons, HttpStatus.OK);
        } catch (GenericException e) {
            return new ResponseEntity<>((List<CouponsDTO>) new CouponsDTO().buildErrorResponse(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
