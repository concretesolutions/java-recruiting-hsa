package cl.talavera.api.web.presenter;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.port.category.CategoriesPresenterPort;
import cl.talavera.api.web.view.CategoryView;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriesPresenter implements CategoriesPresenterPort {
    private List<CategoryView> view;

    @Override
    public void present(List<Category> categories) {
        this.view = from(categories);
    }

    @Override
    public List<CategoryView> retrieve() {
        return view;
    }
    private List<CategoryView> from(List<Category> categories) {
        return categories.stream()
                .map(c -> CategoryView.from(c))
                .collect(Collectors.toList());
    }
}
