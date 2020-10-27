package com.desafio.sha.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
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
import com.desafio.sha.domain.Coupons;
import com.desafio.sha.util.Conversiones;

@Service
public class CuponesService {

	@Autowired
	RestConfig restConfig;

	@Value("${url.cupones}")
	private String urlCupones;
	
	@Autowired
	CategoriasService cat;

	private final Logger log = LoggerFactory.getLogger(CuponesService.class);

	
	/**
	 * Metodo que retoorna los cupones obtenidos desde la api externa, excluye los expirados.
	 * @return List<Coupons>
	 */
	public List<Coupons> getCuponesValidos(){
		List<Coupons> cupones = obtenerCuponesApi();
		Date fechaActual= Calendar.getInstance().getTime();
		List<Coupons> cuponesNoExpirados = new ArrayList<Coupons>();
		for(Coupons cupon : cupones) {
			Date dateCupon = Conversiones.stringToDateFormat(cupon.getExpiresAt(), "yyyy-MM-dd");
			if(fechaActual.before(dateCupon)) {
				cuponesNoExpirados.add(cupon);
			}
		}
		return cuponesNoExpirados;
		
	}
	
	
	
	private List<Coupons> obtenerCuponesApi() {
		RestTemplate restTemplate = restConfig.getRestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");

		HttpEntity<Object> entity = new HttpEntity(headers);

		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		try {
			ResponseEntity<List<Coupons>> result = restTemplate.exchange(urlCupones, HttpMethod.GET, entity,
					new ParameterizedTypeReference<List<Coupons>>() {
					});

			log.info("Respuesta {}", result.getStatusCode().value());
			return result.getBody();

		} catch (HttpStatusCodeException exception) {
			log.warn("Respuesta {}", exception.getStatusCode().value());
			log.info("Mensaje {}", exception.getResponseBodyAsString());
			return null;
		}

	}
}
