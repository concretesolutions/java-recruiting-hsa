package cl.talavera.api.data;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.port.CategoryDaoPort;

import java.util.List;
import java.util.Objects;

public class CategoryDao implements CategoryDaoPort {
    private final CategoryRestRepository repository;

    public CategoryDao(CategoryRestRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getTopCategories() {
        return repository.get();
    }
}
