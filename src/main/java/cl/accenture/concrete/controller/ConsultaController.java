package cl.accenture.concrete.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.accenture.concrete.domain.ResponseCategory;
import cl.accenture.concrete.domain.ResponseCoupon;
import cl.accenture.concrete.service.ConcreteServiceImpl;


/**
 * @author juan.horta.lucero
 * Controller del proyecto
 */
@RestController
@RequestMapping("/concrete")
public class ConsultaController {
	
	@Autowired
	ConcreteServiceImpl concreteService ;

	
	@GetMapping(value = "/categories/top-five", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ResponseCategory>> getTopFive()
	{
		return new ResponseEntity<>(concreteService.getTopFive(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/categories/remaining", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ResponseCategory>> getRemaining()
	{
		return new ResponseEntity<>(concreteService.getRemaining(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/coupons/valids", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ResponseCoupon>> getValidsCoupons()
	{
		return new ResponseEntity<>(concreteService.getValidsCoupons(), HttpStatus.OK);
	}

}
