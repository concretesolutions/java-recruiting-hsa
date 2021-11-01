package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.dto.Category;
import com.proyecto.service.ICategoriaService;

@RestController
@RequestMapping("/api/categoria/mobile") 
public class CategoriaController
{
	@Autowired
	private ICategoriaService servicio;
	
	@GetMapping("/getCarrusel") 
	public ResponseEntity<Object> listar()   // http://localhost:8080/api/categoria/mobile/getCarrusel
	{ 
		Category categoria = servicio.obtener();
		
		if (categoria != null)
			return ResponseEntity.ok(categoria);
		else 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se obtuvieron resultados");
	} 
	

}
