package com.desafio.sha.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.desafio.sha.config.RestConfig;
import com.desafio.sha.domain.Categories;
import com.desafio.sha.domain.ResponseCategories;

@Service
public class CategoriasService {
	@Autowired
	RestConfig restConfig;

	@Value("${url.categorias}")
	private String urlCategorias;

	private final Logger log = LoggerFactory.getLogger(CategoriasService.class);

	/**
	 * Metodo para llamar a la api externa
	 * @return Categories
	 */
	private Categories obtenerCategoriasApi() {
		RestTemplate restTemplate = restConfig.getRestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");

		HttpEntity<Object> entity = new HttpEntity(headers);

		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		try {
			ResponseEntity<Categories> result = restTemplate.exchange(urlCategorias, HttpMethod.GET, entity,
					Categories.class);

			log.info("Respuesta {}", result.getStatusCode().value());
			return result.getBody();

		} catch (HttpStatusCodeException exception) {
			log.warn("Respuesta {}", exception.getStatusCode().value());
			log.info("Mensaje {}", exception.getResponseBodyAsString());
			return null;
		}

	}

	/**
	 * Metodo que retorna la lista de las 5 mejores rankeadas
	 * @return List<ResponseCategories>
	 */
	public List<ResponseCategories> getTopFive() {
		List<ResponseCategories> listCategories = orderedCategory(obtenerCategoriasApi().getSubcategories().get(0).getSubcategories());
		List<ResponseCategories> sortedList = listCategories.stream()
				.sorted(Comparator.comparing(ResponseCategories::getRelevance).reversed())
				.collect(Collectors.toList());
		
		
		List<ResponseCategories> listaTopFive = sortedList.stream().limit(5).collect(Collectors.toList());
		return listaTopFive;
	}
	
	/**
	 * Metodo que retorna la lista de categoria excluyendo a las 5 mejores rankeadas
	 * @return List<ResponseCategories>
	 */
	public List<ResponseCategories> getRemaining() {
	
		List<ResponseCategories> listCategories = orderedCategory(obtenerCategoriasApi().getSubcategories().get(0).getSubcategories());
		List<ResponseCategories> sortedList = listCategories.stream()
				.sorted(Comparator.comparing(ResponseCategories::getRelevance).reversed())
				.collect(Collectors.toList());
		
		for(int i=0; i<5;i++) {
			sortedList.remove(0);
		}
		return sortedList;
	}
	
	

	/**
	 * Metodo que ordena deja todas las subcategorias en una una lista de ResponseCategories
	 * @param subCategories Lista obtenida desde la api externa
	 * @return List<ResponseCategories>
	 */
	private List<ResponseCategories> orderedCategory(List<Categories> subCategories) {
		List<ResponseCategories> listCategories = new ArrayList<ResponseCategories>();
	
		for (Categories cat : subCategories) {
			ResponseCategories nuevaCategoria = new ResponseCategories();
			nuevaCategoria.setId(cat.getId());
			nuevaCategoria.setName(cat.getName());
			nuevaCategoria.setRelevance(cat.getRelevance());
			nuevaCategoria.setSmallImageUrl(cat.getSmallImageUrl());
			listCategories.add(nuevaCategoria);
			if(!cat.getSubcategories().isEmpty()) {
				
				for (Categories cat2 : cat.getSubcategories()) {
					ResponseCategories nuevaCategoria2 = new ResponseCategories();
					nuevaCategoria2.setId(cat2.getId());
					nuevaCategoria2.setName(cat2.getName());
					nuevaCategoria2.setRelevance(cat2.getRelevance());
					if(cat2.getSmallImageUrl()!=null)
						nuevaCategoria2.setSmallImageUrl(cat2.getSmallImageUrl());
					else 
						nuevaCategoria2.setSmallImageUrl(cat.getSmallImageUrl());

					listCategories.add(nuevaCategoria2);
					if(!cat.getSubcategories().isEmpty()) {
						for (Categories cat3 : cat2.getSubcategories()) {
							ResponseCategories nuevaCategoria3 = new ResponseCategories();
							nuevaCategoria3.setId(cat3.getId());
							nuevaCategoria3.setName(cat3.getName());
							nuevaCategoria3.setRelevance(cat3.getRelevance());
							if(cat3.getSmallImageUrl()!=null)
								nuevaCategoria3.setSmallImageUrl(cat3.getSmallImageUrl());
							else
								nuevaCategoria3.setSmallImageUrl(cat2.getSmallImageUrl());

							listCategories.add(nuevaCategoria3);
							
							log.info("categoria  {}", cat3.toString());
						}
					}
					log.info("categoria  {}", cat2.toString());
				}
			}
			log.info("categoria  {}", cat.toString());
		}
		return listCategories;
	}

	

}
