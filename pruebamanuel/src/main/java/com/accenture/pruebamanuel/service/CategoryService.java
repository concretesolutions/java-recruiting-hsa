package com.accenture.pruebamanuel.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.pruebamanuel.client.CategoryClient;
import com.accenture.pruebamanuel.exception.ServiceUnavailableException;
import com.accenture.pruebamanuel.model.Categoria;
import com.accenture.pruebamanuel.model.Categorias;
import com.accenture.pruebamanuel.util.Constant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

		Categoria responseApi = new Categoria();

		try {
			responseApi = categoryClient.getAllCategories().getBody();
		} catch (Exception e) {
			log.error("[getCoupon]Error ocurrio un error al ejecutar la api de Categoria");
			throw new ServiceUnavailableException(Constant.SERVICEUNAVAILABLE_MESSAGE,
					Constant.SERVICEUNAVAILABLE_SOLUTION, Constant.SERVICEUNAVAILABLE_CODE);
		}

		List<Categoria> topFive = getTopFive(responseApi);
		List<Categoria> noTop = getNoTop(responseApi);

		Categorias categorias = new Categorias();
		categorias.setTop5Categoria(topFive);
		categorias.setCategorias(noTop);
		log.debug("[getAllCategories] Fin.");
		return categorias;
	}

	/**
	 * Metodo que obtiene el top5 categorias.
	 * 
	 * @param responseApi Categoria.
	 * @return List Categoria.
	 */
	private List<Categoria> getTopFive(Categoria responseApi) {

		List<Categoria> listFinal = new ArrayList<>();
		getCategory(responseApi, listFinal);

		List<Categoria> listTopFive = listFinal.stream().filter(
				subCat -> subCat.getRelevance() != null && subCat.getRelevance() <= 5 && subCat.getRelevance() > 0)
				.collect(Collectors.toList());

		listTopFive.sort(Comparator.comparingInt(Categoria::getRelevance));

		return listTopFive;
	}

	/**
	 * Metodo que obtiene los no top categorias.
	 * 
	 * @param responseApi Categoria.
	 * @return List Categoria.
	 */
	private List<Categoria> getNoTop(Categoria responseApi) {

		List<Categoria> listFinal = new ArrayList<>();
		getCategory(responseApi, listFinal);

		List<Categoria> listNoTop = listFinal.stream().filter(
				subCat -> subCat.getRelevance() == null || subCat.getRelevance() > 5 && subCat.getRelevance() == 0)
				.collect(Collectors.toList());

		return listNoTop;
	}

	/**
	 * Metodo que obtiene de manera ordenada las categorias
	 * 
	 * @param listCategory Categoria
	 * @param listFinal    List<Categoria>
	 */
	private void getCategory(Categoria listCategory, List<Categoria> listFinal) {

		Categoria copiaCategoria = copyCategoryObject(listCategory);
		copiaCategoria.setSubcategories(null);

		listFinal.add(copiaCategoria);

		if (listCategory.getSubcategories() != null && !listCategory.getSubcategories().isEmpty()) {
			for (Categoria cat : listCategory.getSubcategories()) {
				getCategory(cat, listFinal);
			}
		}

	}

	/**
	 * Metodo que retorna un objeto clonado.
	 * 
	 * @param Objeto Categoria a clonar.
	 * @return Objeto clonado.
	 */
	private Categoria copyCategoryObject(Categoria categoria) {

		Categoria objectCopy;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectCopy = objectMapper.readValue(objectMapper.writeValueAsString(categoria), Categoria.class);
		} catch (JsonProcessingException e) {
			log.error("Error al copiar un objeto Category con ObjectMapper.", e);
			throw new ServiceUnavailableException(Constant.SERVICEUNAVAILABLE_MESSAGE,
					Constant.SERVICEUNAVAILABLE_SOLUTION, "[addCategoryAndInsepct]");
		}
		return objectCopy;
	}

}
