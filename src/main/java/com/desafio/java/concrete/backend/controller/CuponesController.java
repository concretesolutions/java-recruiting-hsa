package com.desafio.java.concrete.backend.controller;

import com.desafio.java.concrete.backend.services.CuponesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CuponesController {
    @Autowired
    CuponesServices cuponesServices;

    @GetMapping(value="/carrusel-cupon", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String getCarruselCupones(){
        return cuponesServices.getCarruselCupones();
    }



}
