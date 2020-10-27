package com.accenture.client;

import static java.util.Objects.isNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.dto.CategoryDTO;
import com.accenture.exception.GenericNotFoundException;
import com.accenture.exception.ServiceException;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author
 *
 */
@Log4j2
@Service
public class ClientCategory {

	@Value("${endpoint.categories}")
	private String url;

	@Autowired
	private RestTemplate restTemplate;

	public CategoryDTO call() throws ServiceException, GenericNotFoundException {
		log.debug("call");
		CategoryDTO resp = null;

		try {
			resp = this.restTemplate.getForObject(this.url, CategoryDTO.class);
		} catch (Exception e) {
			throw new ServiceException("Error al consultar servicio: " + e);
		}
		if (isNull(resp)) {
			throw new GenericNotFoundException("No se encuentran categorías");
		}
		return resp;
	}

}
