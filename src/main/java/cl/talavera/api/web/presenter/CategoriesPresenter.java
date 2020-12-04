package cl.talavera.api.web.presenter;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.port.category.CategoriesPresenterPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CategoriesPresenter implements CategoriesPresenterPort {
    Logger logger = LoggerFactory.getLogger(CategoriesPresenter.class);
    private List<Category> view;

    @Override
    public void present(List<Category> categories) {
        this.view = categories;
    }

    @Override
    public List<Category> retrieve() {
        return view;
    }

}
