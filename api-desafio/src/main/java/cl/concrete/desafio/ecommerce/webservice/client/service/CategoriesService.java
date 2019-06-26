package cl.concrete.desafio.ecommerce.webservice.client.service;

import java.util.List;

import cl.concrete.desafio.ecommerce.webservice.client.model.Category;

public interface CategoriesService {
	
	public List<Category> findAll();
	
}
