package cl.talavera.api.interactor;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.interactor.TopCategoriesInteractor;
import cl.talavera.api.core.port.category.CategoriesPresenterPort;
import cl.talavera.api.core.port.category.CategoryDaoPort;
import cl.talavera.api.core.port.category.TopCategoriesInteractorPort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class TopCategoriesInteractorShould {
    @Test
    void run() {

        CategoriesPresenterPort presenter = mock(CategoriesPresenterPort.class);
        CategoryDaoPort dao = mock(CategoryDaoPort.class);
        List<Category> categories = categories();
        when(dao.getTopCategories()).thenReturn(categories);
        TopCategoriesInteractorPort interactor = new TopCategoriesInteractor(dao,presenter);


        when(dao.getTopCategories()).thenReturn(categories);
        interactor.run();
        verify(dao,times(1)).getTopCategories();
        verify(presenter,times(1)).present(categories);
    }

    private List<Category> categories() {
        List<Category> list = new ArrayList<>();
        return list;
    }
}
