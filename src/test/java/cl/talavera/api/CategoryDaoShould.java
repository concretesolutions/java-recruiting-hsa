package cl.talavera.api;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.port.CategoryDaoPort;
import cl.talavera.api.data.CategoryDao;
import cl.talavera.api.data.CategoryRestRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CategoryDaoShould {
    @Test
    void getTopCategories() {
        CategoryRestRepository repository = mock(CategoryRestRepository.class);
        CategoryDaoPort dao = new CategoryDao(repository);

        List<Category> expected = expected();
        when(repository.get()).thenReturn(expected);

        List<Category> result = dao.getTopCategories();
        assertThat(result, equalTo(expected));
    }

    private List<Category> expected() {
        List<Category> list = new ArrayList<>();
        list.add(Category.builder().name("categoria").build());
        return list;
    }
}
