package cl.accenture.concrete.feing.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.accenture.concrete.domain.Categories;
import cl.accenture.concrete.feing.api.configuration.CategoriesConfiguration;
import feign.Headers;


@FeignClient(url="${api.categori.url}", name="${api.categori.name}", configuration = CategoriesConfiguration.class)
public interface CategoriesClient {

	@GetMapping("/categories")
	@Headers("accept: application/json")
	public Categories getAllCategories();
	
}
