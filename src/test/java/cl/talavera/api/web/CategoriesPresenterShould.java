package cl.talavera.api.web;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.port.category.CategoriesPresenterPort;
import cl.talavera.api.web.presenter.CategoriesPresenter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CategoriesPresenterShould {
    @Test
    void present_and_retrieve() {
        CategoriesPresenterPort presenter = new CategoriesPresenter();
        List<Category> categories = new ArrayList<>();
        categories.add(Category.builder()
                .name("categoria")
                .build());
        presenter.present(categories);

        List<Category> view = presenter.retrieve();
        assertThat(view, equalTo(expected()));

    }

    private List<Category> expected() {
        List<Category> list = new ArrayList<>();
        list.add(Category.builder()
                .name("categoria")
                .build());
        return list;
    }
}
