package cl.concrete.desafio.webservice.client.rest;

import cl.concrete.desafio.webservice.client.model.CategoryDto;
import feign.RequestLine;

public interface CategoriesClientInterface {

	@RequestLine("GET")
	public CategoryDto[] findAll();
	
}
