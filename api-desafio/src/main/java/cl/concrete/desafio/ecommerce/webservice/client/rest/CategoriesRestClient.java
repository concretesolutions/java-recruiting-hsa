package cl.concrete.desafio.ecommerce.webservice.client.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.concrete.desafio.ecommerce.webservice.client.model.CategoryDto;

@FeignClient(name = "${categories.webservice.client.service}", url = "${categories.webservice.client.endpoint}")
public interface CategoriesRestClient {

	@RequestMapping(method = RequestMethod.GET, value = "/${categories.webservice.client.service}")
	public CategoryDto findAll();

}
