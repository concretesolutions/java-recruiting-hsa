package cl.accenture.concrete.feing.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.accenture.concrete.domain.Categories;
import feign.Headers;

/**
 * Cliente Feign que realiza las llamadas a la api de categorias
 * @author c.leon.palacios
 *
 */
@FeignClient(url="${api.categori.url}", name="${api.categori.name}")
public interface CategoriesClient {

	@GetMapping("/categories")
	@Headers("accept: application/json")
	public Categories getAllCategories();
	
}
