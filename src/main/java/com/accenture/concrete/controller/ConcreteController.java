package com.accenture.concrete.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.concrete.domain.Coupon;
import com.accenture.concrete.domain.SubCategoriaN2;
import com.accenture.concrete.service.impl.IConcreteService;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@RestController
@RequestMapping("/accenture")
@EnableSwagger2
public class ConcreteController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IConcreteService iConcreteService;

	/**
	 * Gets the categorias.
	 *
	 * @return the categorias
	 */
	@GetMapping(path = "/topCategory", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubCategoriaN2>> getCategorias() {

		log.info("---------------------------INICIO: getCategorias--------------------------");
		List<SubCategoriaN2> categorias = iConcreteService.getTopCategorias();
		log.info("-----------------------------FIN: getCategorias---------------------------");
		return new ResponseEntity<>(categorias, HttpStatus.OK);
	}

	/**
	 * Gets the other categorys.
	 *
	 * @return the other categorys
	 */
	@GetMapping(path = "/otherCategory", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubCategoriaN2>> getOtherCategorys() {
		log.info("---------------------------INICIO: getOtherCategorys--------------------------");
		List<SubCategoriaN2> categoriesOther = iConcreteService.getOthersCategorys();
		log.info("-----------------------------FIN: getOtherCategorys---------------------------");
		return new ResponseEntity<>(categoriesOther, HttpStatus.OK);
	}

	/**
	 * Gets the cupones.
	 *
	 * @return the cupones
	 */
	@GetMapping(path = "/getCouponsNoExp", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Coupon>> getCupones() {
		log.info("---------------------------INICIO: getCupones--------------------------");
		List<Coupon> coupones = iConcreteService.getCupones();
		log.info("-----------------------------FIN: getCupones---------------------------");
		return new ResponseEntity<>(coupones, HttpStatus.OK);
	}

}
