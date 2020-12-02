package cl.talavera.api.data;

import cl.talavera.api.core.domain.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRestRepository {

    private List<Category> categories = new ArrayList<>();

    public List<Category> get() {
        categories.add(Category.builder().name("categoria").build());

        return categories;
    }
}
