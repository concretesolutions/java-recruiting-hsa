package cl.mobile.bff.client.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.mobile.bff.domain.CategoryClientResponse;
import feign.Headers;;

@Headers("accept: application/json")
@FeignClient(value = "category", url = "https://cs-hsa-api-categories.herokuapp.com")
public interface CategoryClient {
	
	@GetMapping(value = "/categories")
	public CategoryClientResponse getCategories();
}
