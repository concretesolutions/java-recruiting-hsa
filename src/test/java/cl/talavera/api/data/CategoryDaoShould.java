package cl.talavera.api.data;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.port.category.CategoryDaoPort;
import org.junit.jupiter.api.Test;

import java.util.List;

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


        CategoryResponse categoryThree = new CategoryResponse();
        categoryThree.setName("categoria3");
        categoryThree.setRelevance(2);
        List<CategoryResponse> levelFour = asList(categoryThree);

        CategoryResponse categoryFour = new CategoryResponse();
        categoryFour.setName("categoria4");
        categoryFour.setRelevance(1);
        categoryFour.setSubcategories(levelFour);
        List<CategoryResponse> levelThree = asList(categoryFour);


        CategoryResponse categoryTwo = new CategoryResponse();
        categoryTwo.setName("categoria2");
        categoryTwo.setRelevance(3);
        categoryTwo.setSubcategories(levelThree);
        List<CategoryResponse> levelTwo = asList(categoryTwo);

        CategoryResponse response = new CategoryResponse();
        response.setName("categoria1");
        response.setRelevance(4);
        response.setSubcategories(levelTwo);

        return asList(response);
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
