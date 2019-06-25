package cl.concrete.desafio.ecommerce.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.concrete.desafio.ecommerce.webservice.client.model.Category;
import cl.concrete.desafio.ecommerce.webservice.client.service.CategoriesServiceImpl;

@RestController
public class CategoriesController {

	@Autowired
	private CategoriesServiceImpl service;
	
	@RequestMapping("/categories")
	public List<Category> findAll() {
		return this.service.findAll();
	}
}
