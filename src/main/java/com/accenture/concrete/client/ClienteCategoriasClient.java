package com.accenture.concrete.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.accenture.concrete.domain.Categories;
import com.accenture.concrete.domain.CategoryThree;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteCategoriasClient implements IClienteCategorias {

	private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private CacheManager cacheManager;

	@Value("${client.url.service.categorias}")
	private String url;

	/**
	 * Gets the categorias.
	 *
	 * @return the categorias
	 */
	@Cacheable("categories")
	public List<Categories> getCategorias() {
		HttpEntity<String> request = new HttpEntity<>(null);
		ResponseEntity<CategoryThree> entity = new ResponseEntity<>(HttpStatus.OK);
		try {
			log.debug("---------------------------INICIO: getCategorias--------------------------");
			entity = restTemplate.exchange(url, HttpMethod.GET, request, CategoryThree.class);
			log.debug("---------------------------INICIO: getCategorias--------------------------");
		} catch (RestClientException e) {
			log.error("Error : ", e);
		}
		return entity.getBody().getSubcategories();

	}

	/**
	 * Clear cache schedule 2 minutos.
	 * La implementacion de este metodo esta en caso de inestabilidad y/o demoras en la respuesta del servicio
	 */
	@Scheduled(cron = "0 1/2 * * * *")
	public void clearCacheSchedule() {

		cacheManager.getCache("categories").clear();
		log.debug("Clean Cache categories");
		getCategorias();
	}

}
