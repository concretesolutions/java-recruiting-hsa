package com.concrete.javarecruitinghsa.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.concrete.javarecruitinghsa.dto.categorie.Categorie;
import com.concrete.javarecruitinghsa.service.CategorieService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CategorieRestController {
	
	@Autowired
	private CategorieService categorieService;
	
	@ApiOperation( value = "Obtiene carrusel de categorias", response = Categorie.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "registro encontrado", response = Categorie.class)
	   ,@ApiResponse(code = 404, message = "registro no encontrado", response=HttpStatus.class)
	})
	@ResponseStatus(code = HttpStatus.OK)	
	@GetMapping("/v1/categorie/carrousel")
	public ResponseEntity<?> getCarrousel(){
		List<Categorie> categories = categorieService.getCarrousel();
		if(!categories.isEmpty()) {
			return ResponseEntity.ok(categories);
		}else {
			return ResponseEntity.notFound().build();
		}			
	}
	
	@ApiOperation( value = "Obtiene grilla de categorías", response = Categorie.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "registro encontrado", response = Categorie.class)
	   ,@ApiResponse(code = 404, message = "registro no encontrado", response=HttpStatus.class)
	})
	@ResponseStatus(code = HttpStatus.OK)	
	@GetMapping("/v1/categorie/grid")
	public ResponseEntity<?> getGrid(){
		List<Categorie> categories = categorieService.getGrid();
		if(!categories.isEmpty()) {
			return ResponseEntity.ok(categories);
		}else {
			return ResponseEntity.notFound().build();
		}			
	}
	
}
