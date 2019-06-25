package cl.concrete.desafio.ecommerce.webservice.client.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.concrete.desafio.ecommerce.webservice.client.model.CategoryDto;

@FeignClient(name = "categories", url = "https://cs-hsa-api-categories.herokuapp.com")
public interface CategoriesRestClient {

	@RequestMapping(method = RequestMethod.GET, value = "/categories")
	public CategoryDto[] findAll();

}
