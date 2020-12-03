package com.desafio.accenture.backend.javarecruitinghsa.controller;


import com.desafio.accenture.backend.javarecruitinghsa.constant.Contansts;
import com.desafio.accenture.backend.javarecruitinghsa.dto.CouponsDTO;
import com.desafio.accenture.backend.javarecruitinghsa.dto.response.GenericResponse;
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
    public ResponseEntity<GenericResponse> listaCoupons() {
        GenericResponse response = new GenericResponse();
        try {
            List<CouponsDTO>  lstCoupons = couponsService.getCarruselCupones();
            response.setCodResponse(Contansts.CODIGO_RESPUESTA_CORRECTA);
            response.setMessage("OK");
            response.setResult(lstCoupons);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (GenericException e) {
            response.setCodResponse(Contansts.CODIGO_RESPUESTA_INCORRECTA);
            response.setMessage(e.getMessage());
            response.setResult(null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
