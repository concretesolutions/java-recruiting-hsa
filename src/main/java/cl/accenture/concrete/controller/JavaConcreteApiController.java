package cl.accenture.concrete.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.accenture.concrete.domain.BasicCategory;
import cl.accenture.concrete.domain.DataCoupon;
import cl.accenture.concrete.service.interfaces.JavaConcreteApiService;

/**
 * 
 * @author c.leon.palacios
 *
 */
@RestController
@RequestMapping(value = "/backend/api")
public class JavaConcreteApiController {

	@Autowired
	JavaConcreteApiService service;
	
	/**
	 * Obtiene las top 5 categorias con mayor relevancia
	 * @return
	 */
	@GetMapping(value = "/categories/top5", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BasicCategory>> getTopFiveCategories()
	{
		return new ResponseEntity<>(service.getTopFiveCategories(), HttpStatus.OK);
	}
	
	/**
	 * Obtiene los cupones no expirados
	 * @return
	 */
	@GetMapping(value = "/coupons", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DataCoupon>> getValidsCoupons()
	{
		return new ResponseEntity<>(service.getValidsCoupons(), HttpStatus.OK);
	}
	
	/**
	 * Obtiene el resto de categorias que no pertenecen a las top 5 con mayor relevancia
	 * @return
	 */
	@GetMapping(value = "/categories/remaining", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BasicCategory>> getRemainingCategories()
	{
		return new ResponseEntity<>(service.getRemainingCategories(), HttpStatus.OK);
	}
}
