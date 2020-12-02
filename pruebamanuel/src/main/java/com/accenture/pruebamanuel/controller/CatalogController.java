package com.accenture.pruebamanuel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.pruebamanuel.exception.ServiceUnavailableException;
import com.accenture.pruebamanuel.model.Cupon;
import com.accenture.pruebamanuel.service.CouponService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.log4j.Log4j2;

/**
 * Controller que tiene el negocio de los cupones
 * 
 * @author Manuel Jimenez.
 */
@Log4j2
@RestController
public class CatalogController {

	/**
	 * Instancia de CuponService
	 */
	@Autowired
	private CouponService cuponService;

	/**
	 * Metodo que retorna un listado de sin Expirar.
	 * 
	 * @return List Cupon.
	 */
	@CircuitBreaker(name = "getCoupons", fallbackMethod = "fallbackGetListCoupon")
	@GetMapping("/coupon/no-expired")
	public ResponseEntity<List<Cupon>> getCoupons() {

		log.info("[getCoupons] Inicio.");
		List<Cupon> response = cuponService.getCoupon();
		log.info("[getCoupons] Fin.");

		return new ResponseEntity<List<Cupon>>(response, HttpStatus.OK);
	}

	/**
	 * metodo fallback para cuando el servicio getCoupons esta indisponibilizado.
	 * 
	 * @return listado de cupon con estado de la solicitud.
	 */
	public ResponseEntity<List<Cupon>> fallbackGetListCoupon(ServiceUnavailableException e) {

		log.warn("[fallbackGetListCoupon] Circuit breaker Activo error al obtener listado de cupones {}",
				e.getMessage());
		throw new ServiceUnavailableException("Circuit breaker para obtener el numero de la orden activo",
				"Error al obtener el numero de la orden, favor intenta mas tarde", "fallbackGetListCoupon");
	}
}
