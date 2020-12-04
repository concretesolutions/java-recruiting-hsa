package cl.talavera.api.data;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.port.category.CategoryDaoPort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CategoryDaoShould {
    @Test
    void getTopCategories() {
        CategoryRestRepository repository = mock(CategoryRestRepository.class);
        CategoryDaoPort dao = new CategoryDao(repository);

        when(repository.getCategories()).thenReturn(categories());

        List<Category> result = dao.getTopCategories();
        assertThat(result, equalTo(expected()));
    }

    private List<CategoryResponse> categories() {

        List<CategoryResponse> levelFour = asList(categoryResponse(new ArrayList<>(), "categoria3", 2));
        List<CategoryResponse> levelThree = asList(categoryResponse(levelFour, "categoria4", 1));
        List<CategoryResponse> levelTwo = asList(categoryResponse(levelThree, "categoria2", 3));
        return asList(categoryResponse(levelTwo, "categoria1", 4));
    }

    private CategoryResponse categoryResponse(List<CategoryResponse> levelFour, String categoria4, int i) {
        CategoryResponse categoryFour = new CategoryResponse();
        categoryFour.setName(categoria4);
        categoryFour.setRelevance(i);
        categoryFour.setSubcategories(levelFour);
        return categoryFour;
    }

    private List<Category> expected() {
        return asList(
                    Category.builder().name("categoria1").relevance(4).build(),
                    Category.builder().name("categoria2").relevance(3).build(),
                    Category.builder().name("categoria3").relevance(2).build(),
                    Category.builder().name("categoria4").relevance(1).build()
                );
    }
}
