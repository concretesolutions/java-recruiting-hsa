package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.dto.Category;
import com.proyecto.service.ICategoriaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/categoria/mobile") 
public class CategoriaController
{
	@Autowired
	private ICategoriaService servicio;
	

	@ApiOperation(value = "Carrusel con Top 5 categorias")
	@GetMapping("/getCarrusel") 
	public ResponseEntity<Category> getCarrusel()
	{ 
		Category categoria = servicio.obtener();
		
		if (categoria != null) 
		{
			if (categoria.getSubcategories() != null && ! categoria.getSubcategories().isEmpty()) 
				servicio.filtrarImagenesMobile( categoria.getSubcategories() );
			
			return ResponseEntity.ok(categoria);
		}
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	} 

}

























