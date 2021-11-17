package cl.mobile.api.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.mobile.api.backend.service.CategoriaService;
import cl.mobile.api.backend.service.CuponesService;
import cl.mobile.api.backend.to.CategoriaResponseRest;
import cl.mobile.api.backend.to.CuponesResponseRest;

@RestController
@RequestMapping("/mobile-api")
public class MobileController {
	
	@Autowired	
	private CategoriaService categoriaService;
	
	@Autowired	
	private CuponesService cuponesService;
	
	
	/**
	 * Obtiene top 5 categorias 
	 * */
	@GetMapping("/categoriasTop5")
	public ResponseEntity<CategoriaResponseRest>  categoriasTop5() 
	{
		ResponseEntity<CategoriaResponseRest> response = categoriaService.obtieneCategoriasTop5();
		return response;

	}
	/**
	 * Obtiene cateogorias no top 5
	 * */
	@GetMapping("/categoriasNoTop5")
	public ResponseEntity<CategoriaResponseRest>  categoriasNoTop5() 
	{
		ResponseEntity<CategoriaResponseRest> response = categoriaService.obtieneCategoriasNoTop5();
		return response;

	}
	
	/** Obtiene cupones vigentes*/ 	
	@GetMapping("/cuponesVigentes")
	public ResponseEntity<CuponesResponseRest>  cuponesVigentes() 
	{
		ResponseEntity<CuponesResponseRest> response = cuponesService.obtieneCuponesVigentes();
		return response;
	}	
	
}
