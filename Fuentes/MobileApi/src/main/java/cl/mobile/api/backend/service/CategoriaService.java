package cl.mobile.api.backend.service;

import org.springframework.http.ResponseEntity;

import cl.mobile.api.backend.to.CategoriaResponseRest;

public interface CategoriaService {
	
	public ResponseEntity<CategoriaResponseRest> obtieneCategoriasTop5();
	public ResponseEntity<CategoriaResponseRest> obtieneCategoriasNoTop5();

}
