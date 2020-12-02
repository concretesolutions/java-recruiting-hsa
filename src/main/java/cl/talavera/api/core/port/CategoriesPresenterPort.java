package cl.talavera.api.core.port;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.rest.CategoryView;

import java.util.List;

public interface CategoriesPresenterPort {
    void present(List<Category> categories);

    List<CategoryView> retrieve();
}
