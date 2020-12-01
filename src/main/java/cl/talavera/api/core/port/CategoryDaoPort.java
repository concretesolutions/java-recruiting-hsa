package cl.talavera.api.core.port;

import cl.talavera.api.core.domain.Category;

import java.util.List;

public interface CategoryDaoPort {
    List<Category> getTopCategories();
}
