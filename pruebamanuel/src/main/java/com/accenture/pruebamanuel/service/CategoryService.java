package com.accenture.pruebamanuel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.pruebamanuel.client.CategoryClient;
import com.accenture.pruebamanuel.model.Categoria;
import com.accenture.pruebamanuel.model.Categorias;

import lombok.extern.log4j.Log4j2;

/**
 * Service que contiene toda la logica solicitada sobre Categorias.
 * 
 * @author Manuel Jimenez.
 */
@Log4j2
@Service
public class CategoryService {

	/**
	 * Instancia de CategoryClient.
	 */
	@Autowired
	private CategoryClient categoryClient;

	public Categorias getAllCategories() {

		log.debug("[getAllCategories] Inicio.");

		Categoria categoria = categoryClient.getAllCategories().getBody();

		log.debug("[getAllCategories] Fin.");
		return null;
	}
}
