package cl.talavera.api.interactor;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.interactor.ShowCategoriesGridInteractor;
import cl.talavera.api.core.port.category.ShowCategoriesGridInteractorPort;
import cl.talavera.api.core.port.category.CategoriesPresenterPort;
import cl.talavera.api.core.port.category.CategoryDaoPort;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ShowCategoriesGridInteractorShould {

    @Test
    void getGrid() {

        CategoriesPresenterPort presenter = mock(CategoriesPresenterPort.class);
        CategoryDaoPort dao = mock(CategoryDaoPort.class);
        ShowCategoriesGridInteractorPort interactor = new ShowCategoriesGridInteractor(dao,presenter);

        List<Category> categories = categories();
        when(dao.getGrid()).thenReturn(categories);
        interactor.run();

        verify(dao,times(1)).getGrid();
        verify(presenter,times(1)).present(categories);

    }
    private List<Category> categories() {
        return asList(Category.builder().build());
    }
}
