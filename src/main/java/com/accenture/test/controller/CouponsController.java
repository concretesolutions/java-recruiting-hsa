package com.accenture.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.test.dto.Coupons;
import com.accenture.test.service.CouponsService;

@RestController
@Validated
@RequestMapping(value = "/coupons")
public class CouponsController {

	@Autowired
	private CouponsService service;
	
	@GetMapping(value = "/getCouponsNotExpired")
	public ResponseEntity<List<Coupons>> getCouponsNotExpired(){
		List<Coupons> response = service.getCouponsNotExpired();
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
