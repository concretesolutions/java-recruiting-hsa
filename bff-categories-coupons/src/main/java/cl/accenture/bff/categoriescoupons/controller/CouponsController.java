package cl.accenture.bff.categoriescoupons.controller;

import cl.accenture.bff.categoriescoupons.dto.Coupon;
import cl.accenture.bff.categoriescoupons.service.CouponsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * Copyright (c) 2023 Boris Molina
 */
@RestController
@RequestMapping("/api/coupons")
public class CouponsController {

    private final CouponsService couponsService;

    public CouponsController(CouponsService couponsService) {
        this.couponsService = couponsService;
    }

    @GetMapping("/all")
    @Operation(summary = "Obtiene una lista de cupones",
            description = "Retorna una lista de cupones",
            responses = {
                    @ApiResponse(
                            description = "Lista de cupones obtenida con éxito",
                            responseCode = "200", content = @Content),
                    @ApiResponse(
                            description = "Error interno del servidor",
                            responseCode = "500", content = @Content)
            })
    public ResponseEntity<List<Coupon>> getAllCoupons() {
        return ResponseEntity.status(HttpStatus.OK).body(couponsService.getAllCoupons());
    }

    @GetMapping("/valid-coupons")
    @Operation(summary = "Obtiene una lista de cupones vigentes",
            description = "Retorna una lista de cupones vigentes",
            responses = {
                    @ApiResponse(
                            description = "Lista de cupones vigentes obtenida con éxito",
                            responseCode = "200", content = @Content),
                    @ApiResponse(
                            description = "Error interno del servidor",
                            responseCode = "500", content = @Content)
            })
    public ResponseEntity<List<Coupon>> getValidCoupons() {
        return ResponseEntity.status(HttpStatus.OK).body(couponsService.getValidCoupons());
    }

}
