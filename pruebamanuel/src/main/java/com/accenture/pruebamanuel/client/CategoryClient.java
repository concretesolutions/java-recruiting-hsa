package com.accenture.pruebamanuel.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.accenture.pruebamanuel.model.Categoria;

/**
 * Interface que permite la comunicacion con el servicio legado de la api de
 * categorias.
 * 
 * @author Manuel Jimenez.
 */
@FeignClient(name = "category-api", url = "https://cs-hsa-api-categories.herokuapp.com")
public interface CategoryClient {

	/**
	 * Metodo que retorna todas las categorias.
	 * 
	 * @return Object de Categoria.
	 */
	@GetMapping("/categories")
	public ResponseEntity<Categoria> getAllCategories();
}
