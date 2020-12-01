package com.accenture.pruebamanuel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.pruebamanuel.model.Cupon;
import com.accenture.pruebamanuel.service.CouponService;

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
	@GetMapping("/coupon/no-expired")
	public ResponseEntity<List<Cupon>> getCoupons() {

		log.info("[getCoupons] Inicio.");
		List<Cupon> response = cuponService.getCoupon();
		log.info("[getCoupons] Fin.");

		return new ResponseEntity<List<Cupon>>(response, HttpStatus.OK);
	}
}
