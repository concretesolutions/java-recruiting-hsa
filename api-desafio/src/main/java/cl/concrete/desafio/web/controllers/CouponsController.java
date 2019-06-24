package cl.concrete.desafio.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.concrete.desafio.main.APIECommerce;

@RestController
public class CouponsController {

	
	@RequestMapping("/")
	public void index() {
		APIECommerce api = new APIECommerce();
		api.getCoupons();
	}
	
}
