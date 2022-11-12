package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.dto.CouponsDto;
import com.ecommerce.service.CouponsService;
import com.ecommerce.utils.ConstantesUtils;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class CouponsController {

	@Autowired
	private CouponsService service;

	@GetMapping("coupons")
	@Operation(summary = "Get all coupons")
	public ResponseEntity<List<CouponsDto>> getCouponsNotExpired() {

		try {
			List<CouponsDto> couponsList = service.getCouponsNotExpired();
			return ResponseEntity.status(HttpStatus.OK).body(couponsList);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ConstantesUtils.ERROR_OBTENER_CUPONES,
					e);
		}
	}

}
