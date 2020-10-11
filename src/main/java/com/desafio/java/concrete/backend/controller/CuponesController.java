package com.desafio.java.concrete.backend.controller;

import com.desafio.java.concrete.backend.services.CuponesServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Coupons")
public class CuponesController {
    @Autowired
    CuponesServices cuponesServices;

    @ApiOperation(value = "Cupones válidas", notes = "Muestra todos los cupones que no han expirado")
    @GetMapping(value="/carrusel-cupon", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String getCarruselCupones(){
        return cuponesServices.getCarruselCupones();
    }



}
