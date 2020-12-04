package cl.talavera.api.core.port.category;

import cl.talavera.api.core.domain.Category;


import java.util.List;

public interface CategoriesPresenterPort {
    void present(List<Category> categories);

    List<Category> retrieve();
}
