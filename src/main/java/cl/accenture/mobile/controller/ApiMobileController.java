package cl.accenture.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.accenture.mobile.domain.Category;
import cl.accenture.mobile.domain.Coupons;
import cl.accenture.mobile.service.interfaces.ApiMobileSerice;

/**
 * 
 * @author andrea.rojas.ruiz
 *
 */
@RestController
@RequestMapping(value = "/api/mobile")
public class ApiMobileController {
	
	@Autowired
	ApiMobileSerice service;
	
	/**
	 * Obtiene top 5 de las categorias
	 * @return
	 */
	@GetMapping(value = "/categories/carrusel", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> getCarruselCategories()
	{
		return new ResponseEntity<>(service.getCarruselCategories(), HttpStatus.OK);
	}
	
	/**
	 * Obtiene el resto de las categorias
	 * @return
	 */
	@GetMapping(value = "/categories/remaining", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> getRemainingCategories()
	{
		return new ResponseEntity<>(service.getRemainingCategories(), HttpStatus.OK);
	}
	
	/**
	 * Obtiene los cupones no expirados
	 * @return
	 */
	@GetMapping(value = "/coupons/not_expired", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Coupons>> getCouponsNotExpired()
	{
		return new ResponseEntity<>(service.getCouponsNotExpired(), HttpStatus.OK);
	}

}
