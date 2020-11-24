package com.accenture.prueba.controller;

import com.accenture.prueba.dto.CouponsResponseDto;
import com.accenture.prueba.service.CouponsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de funciones de cupones
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class CouponsController {

    /**
     * Bean de servicio de cupones
     */
    private final CouponsService couponsService;

    /**
     * Endpoint para obtener los cupones
     * @param onlyNotExpired Filtro si se quiere solo los cupones no expirados o todos
     *                       false = todos
     *                       true = solo los no expirados
     * @return Objeto con lista de cupones
     */
    @ApiOperation("Obtener los cupones")

    @GetMapping(value = "/coupons")
    public CouponsResponseDto getCoupons(@ApiParam(
            name = "onlyNotExpired",
            type = "boolean",
            value = "parametro para retornar solo cupones no expirados")
                                             @RequestParam(required = false) boolean onlyNotExpired) {
        log.info(String.format("Consultando %s", (onlyNotExpired ? "cupones no expirados" : "todos los cupones")));
        return couponsService.get(onlyNotExpired);
    }

}
