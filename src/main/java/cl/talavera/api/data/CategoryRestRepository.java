package cl.talavera.api.data;

import cl.talavera.api.core.domain.Category;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;


import java.util.List;

public class CategoryRestRepository {

    private RestTemplate rest;
    private List<Category> categories;
    String url = "https://cs-hsa-api-categories.herokuapp.com/categories";

    public CategoryRestRepository() {
        rest = new RestTemplateBuilder().build();
    }

    public List<CategoryResponse> getCategories() {
        CategoryResponse response = rest.getForObject(url,CategoryResponse.class);

        return response.getSubcategories();
    }

}
