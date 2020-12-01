package cl.recruiting.hsa.proyecto.legacy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.recruiting.hsa.proyecto.legacy.model.Category;


@FeignClient(name = "categoryFeignClient", url = "${legacy.category.url}")
public interface  CategoryFeignClient {

	@GetMapping("/categories.json")
    Category getAllCategories();
	
	
}
