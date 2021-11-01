package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.dto.Coupon;
import com.proyecto.service.ICuponService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/cupon/mobile") 
public class CuponController
{
	@Autowired
	ICuponService servicio;
	
	@ApiOperation(value = "Carrusel con cupones que no han expirado")
	@GetMapping("/getCarrusel") 
	public ResponseEntity<List<Coupon>> getCarrusel()   // http://localhost:8080/api/cupon/mobile/getCarrusel
	{ 
		List<Coupon> lista = servicio.obtener();
		
		if (!lista.isEmpty())
			return ResponseEntity.ok(lista);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	} 

}
