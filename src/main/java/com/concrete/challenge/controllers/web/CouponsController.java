package com.concrete.challenge.controllers.web;

import com.concrete.challenge.bean.coupons.external.Coupon;
import com.concrete.challenge.controllers.base.BaseController;
import com.concrete.challenge.service.CouponsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Coupons API", description = "Coupons API")
@RequestMapping("/coupons")
public class CouponsController implements BaseController {

    @Autowired
    private CouponsService couponsService;

    @ApiOperation(value = "View a list of active coupons", response = Coupon.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved active coupons list"),
            @ApiResponse(code = 201, message = "Successfully retrieved empty coupons list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Coupon>> getActiveCoupons() {

        List<Coupon> coupons = couponsService.getActiveCoupons();
        return new ResponseEntity<>(coupons, getResponseHeaders(), !coupons.isEmpty() ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
}
