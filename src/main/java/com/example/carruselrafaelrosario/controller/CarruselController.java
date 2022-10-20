package com.example.carruselrafaelrosario.controller;

import com.example.carruselrafaelrosario.model.Response;
import com.example.carruselrafaelrosario.service.CarruselService;
import com.example.carruselrafaelrosario.service.interfaces.ICarruselService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/concrete")
public class CarruselController {

    @Autowired
    private CarruselService service;

    @RequestMapping(value = "/getCupon", method = RequestMethod.GET)
    @ApiOperation("Obtiene todos los cupones no expirados de forma asincrona, si el api que suministra los datos no responde en 10 segundos regresa una lista vacia")
    @ApiResponse(code = 200, message = "OK")
    public List<Response> getCuponNotExpires(){
        return service.getCuponNotExpires();
    }
}
