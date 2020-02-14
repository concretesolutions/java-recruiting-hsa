package cl.accenture.mobile.feing.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.accenture.mobile.domain.Categories;
import feign.Headers;

/**
 * Cliente Feign que realiza las llamadas a la api de categorias
 * @author andrea.rojas.ruiz
 * 
 *
 */
@FeignClient(url="${api.category.url}", name="${api.category.name}")
public interface CategoriesClient {

	@GetMapping("/categories")
	@Headers("accept: application/json")
	public Categories getCategories();
	
}
