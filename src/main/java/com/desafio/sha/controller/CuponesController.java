package com.desafio.sha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.sha.domain.Coupons;
import com.desafio.sha.service.CuponesService;

@RestController
public class CuponesController {

	@Autowired
	CuponesService cuponesService;
	
	@GetMapping(value = "/cupones", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Coupons>> getTopFive()
	{
		return new ResponseEntity<>(cuponesService.getCuponesValidos(), HttpStatus.OK);
	}
}
