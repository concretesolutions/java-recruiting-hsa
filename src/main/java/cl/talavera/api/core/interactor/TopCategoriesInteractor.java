package cl.talavera.api.core.interactor;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.port.CategoriesPresenterPort;
import cl.talavera.api.core.port.CategoryDaoPort;
import cl.talavera.api.core.port.TopCategoriesInteractorPort;

import java.util.List;

public class TopCategoriesInteractor implements TopCategoriesInteractorPort {
    private final CategoryDaoPort dao;
    private final CategoriesPresenterPort presenter;

    public TopCategoriesInteractor(CategoryDaoPort dao, CategoriesPresenterPort presenter) {
        this.dao = dao;
        this.presenter = presenter;
    }

    @Override
    public void run() {
        List<Category> categories = dao.getTopCategories();
        presenter.view(categories);
    }
}
