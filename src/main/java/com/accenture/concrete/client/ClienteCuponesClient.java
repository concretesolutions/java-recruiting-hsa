package com.accenture.concrete.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.accenture.concrete.domain.Coupon;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteCuponesClient implements IClienteCupones {

	private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private CacheManager cacheManager;
	
	@Value("${client.url.service.cupones}")
	private String url;

	/**
	 * Cupones.
	 *
	 * @return the cupones
	 */
	@Cacheable("coupons")
	public List<Coupon> getCupones() {

		ResponseEntity<List<Coupon>> retornoCoupon = new ResponseEntity<>(HttpStatus.OK);
		try {
			log.debug("---------------------------INICIO: getCupones--------------------------");
			retornoCoupon = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Coupon>>() {
					});
			log.debug("---------------------------INICIO: getCupones--------------------------");
		} catch (RestClientException e) {
			log.error("Error : ", e);
		}
		return retornoCoupon.getBody();
	}
	
	/**
	 * Clear cache schedule 2 minutos.
	 * La implementacion de este metodo esta en caso de inestabilidad y/o demoras en la respuesta del servicio
	 */
	@Scheduled(cron = "0 1/2 * * * *")
	public void clearCacheSchedule() {

		cacheManager.getCache("coupons").clear();
		log.debug("Clean Cache coupons");
		getCupones();
	}

}
