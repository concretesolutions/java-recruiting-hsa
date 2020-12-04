package cl.talavera.api.web;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.port.category.CategoriesPresenterPort;
import cl.talavera.api.core.port.category.TopCategoriesInteractorPort;
import cl.talavera.api.web.endpoint.TopCategoriesEndpoint;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

public class TopCategoriesEndpointShould {
    @Test
    void present() {
        TopCategoriesInteractorPort interactor = mock(TopCategoriesInteractorPort.class);
        CategoriesPresenterPort presenter = mock(CategoriesPresenterPort.class);
        TopCategoriesEndpoint endpoint = new TopCategoriesEndpoint(interactor,presenter);

        List<Category> view = expectedView();
        when(presenter.retrieve()).thenReturn(view);

        ResponseEntity<List<Category>> response = endpoint.present();



        verify(interactor,times(1)).run();
        verify(presenter,times(1)).retrieve();
        assertThat(response, equalTo(ResponseEntity.ok(view)));

    }

    private List<Category> expectedView() {
        List<Category> list = new ArrayList<>();
        list.add(Category.builder().name("category").build());
        return list;
    }
}
