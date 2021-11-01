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

@RestController
@RequestMapping("/api/cupon") 
public class CuponController
{
	@Autowired
	ICuponService servicio;
	
	@GetMapping("/listar") 
	public ResponseEntity<Object> listar()   // http://localhost:8080/api/cupon/listar
	{ 
		List<Coupon> lista = servicio.obtener();
		
		if (!lista.isEmpty())
			return ResponseEntity.ok(lista);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se obtuvieron resultados");
	} 

}
