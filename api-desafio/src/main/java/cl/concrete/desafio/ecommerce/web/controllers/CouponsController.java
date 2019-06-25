package cl.concrete.desafio.ecommerce.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.concrete.desafio.ecommerce.webservice.client.model.Coupon;
import cl.concrete.desafio.ecommerce.webservice.client.service.CouponsServiceImpl;

@RestController
public class CouponsController {
	
	@Autowired
	private CouponsServiceImpl service;
	
	@RequestMapping("/coupons")
	public List<Coupon> findAll() {
		return this.service.findAll();
	}
	
}
