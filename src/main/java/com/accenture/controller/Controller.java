package com.accenture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.dto.CategoryDTO;
import com.accenture.dto.CouponDTO;
import com.accenture.exception.GenericNotFoundException;
import com.accenture.exception.ServiceException;
import com.accenture.service.CategoryService;
import com.accenture.service.CouponService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author
 *
 */
@RestController
@Api(tags = "Controller", value = "Controlador con métodos principales")
@Log4j2
public class Controller {

	private CategoryService catService;
	private CouponService cupService;

	@Autowired
	public Controller(CategoryService catService, CouponService cupService) {
		this.catService = catService;
		this.cupService = cupService;
	}

	/**
	 * <h1>GET method</h1>
	 * 
	 * Get top five categories
	 * 
	 * @return List<CategoryDTO>
	 * @throws GenericNotFoundException
	 * @throws ServiceException
	 */
	@CrossOrigin(origins = "*")
	@ApiOperation(value = "Get top five categories", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "Mensaje correcto", response = HttpStatus.class),
			@ApiResponse(code = 404, message = "Objeto no encontrado", response = HttpStatus.class),
			@ApiResponse(code = 500, message = "Error controlado por un try", response = HttpStatus.class) })
	@GetMapping(value = "/categories/topFive", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryDTO>> getTopFiveCategories() throws ServiceException, GenericNotFoundException {
		log.debug("getTopFiveCategories");
		return new ResponseEntity<>(this.catService.getTopFiveCategories(), HttpStatus.OK);
	}

	/**
	 * <h1>GET method</h1>
	 * 
	 * Get rest of categories
	 * 
	 * @return List<CategoryDTO>
	 * @throws GenericNotFoundException
	 * @throws ServiceException
	 */
	@CrossOrigin(origins = "*")
	@ApiOperation(value = "Get Rest of categories", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "Mensaje correcto", response = HttpStatus.class),
			@ApiResponse(code = 404, message = "Objeto no encontrado", response = HttpStatus.class),
			@ApiResponse(code = 500, message = "Error controlado por un try", response = HttpStatus.class) })
	@GetMapping(value = "/categories/rest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryDTO>> getRestOfCategories() throws ServiceException, GenericNotFoundException {
		log.debug("getRestOfCategories");
		return new ResponseEntity<>(this.catService.getRestOfCategories(), HttpStatus.OK);
	}

	/**
	 * <h1>GET method</h1>
	 * 
	 * Get Not Expired Coupons
	 * 
	 * @return List<CouponDTO>
	 * @throws GenericNotFoundException
	 * @throws ServiceException
	 */
	@CrossOrigin(origins = "*")
	@ApiOperation(value = "Get Not Expired Coupons", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "Mensaje correcto", response = HttpStatus.class),
			@ApiResponse(code = 404, message = "Objeto no encontrado", response = HttpStatus.class),
			@ApiResponse(code = 500, message = "Error controlado por un try", response = HttpStatus.class) })
	@GetMapping(value = "/coupons/notExpired", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CouponDTO>> getNotExpiredCoupons() throws ServiceException, GenericNotFoundException {
		log.debug("getNotExpiredCoupons");
		return new ResponseEntity<>(this.cupService.getNotExpiredCoupons(), HttpStatus.OK);
	}

}
