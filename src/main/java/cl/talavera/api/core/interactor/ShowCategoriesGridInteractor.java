package cl.talavera.api.core.interactor;

import cl.talavera.api.core.port.category.ShowCategoriesGridInteractorPort;
import cl.talavera.api.core.port.category.CategoriesPresenterPort;
import cl.talavera.api.core.port.category.CategoryDaoPort;

public class ShowCategoriesGridInteractor implements ShowCategoriesGridInteractorPort {
    private final CategoryDaoPort dao;
    private final CategoriesPresenterPort presenter;

    public ShowCategoriesGridInteractor(CategoryDaoPort dao, CategoriesPresenterPort presenter) {
        this.dao = dao;
        this.presenter = presenter;
    }

    @Override
    public void run() {
        presenter.present(dao.getGrid());
    }
}
