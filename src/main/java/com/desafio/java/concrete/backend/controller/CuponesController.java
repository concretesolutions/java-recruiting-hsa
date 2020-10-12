package com.desafio.java.concrete.backend.controller;

import com.desafio.java.concrete.backend.services.CuponesServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Coupons")
@RestController
public class CuponesController {
    @Autowired
    CuponesServices cuponesServices;

    @ApiOperation(value = "Cupones válidas", notes = "Muestra todos los cupones que no han expirado")
    @RequestMapping(value="/carrusel-cupon", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getCarruselCupones(){
        return cuponesServices.getCarruselCupones();
    }



}
