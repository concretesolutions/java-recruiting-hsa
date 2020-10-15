package cl.concretesolutions.mobileapp.api.category;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="category-client", url="${category.url.service}")
public interface CategoryClient {
	@GetMapping("/categories")
	CategoryTree getCategories();
}
