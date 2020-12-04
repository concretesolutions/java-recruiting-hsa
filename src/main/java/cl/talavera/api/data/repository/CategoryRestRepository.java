package cl.talavera.api.data.repository;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.data.model.CategoryModel;
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

    public List<CategoryModel> getCategories() {
        CategoryModel response = rest.getForObject(url, CategoryModel.class);

        return response.getSubcategories();
    }

}
