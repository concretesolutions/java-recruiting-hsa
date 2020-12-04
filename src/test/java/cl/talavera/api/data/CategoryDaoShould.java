package cl.talavera.api.data;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.port.category.CategoryDaoPort;
import cl.talavera.api.data.dao.CategoryDao;
import cl.talavera.api.data.model.CategoryModel;
import cl.talavera.api.data.repository.CategoryRestRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    @Test
    void getGrid() {
        CategoryRestRepository repository = mock(CategoryRestRepository.class);
        CategoryDaoPort dao = new CategoryDao(repository);

        when(repository.getCategories()).thenReturn(grid());

        List<Category> result = dao.getGrid();
        assertThat(result, equalTo(expectedGrid()));
    }

    private List<Category> expectedGrid() {
        return asList(
                Category.builder().name("categoria7").relevance(2).build(),
                Category.builder().name("categoria6").relevance(1).build()
        );
    }

    private List<CategoryModel> grid() {

        List<CategoryModel> levelFour = asList(
                categoryResponse(new ArrayList<>(), "categoria3", 45),
                categoryResponse(new ArrayList<>(), "categoria5", 34),
                categoryResponse(new ArrayList<>(), "categoria6", 1),
                categoryResponse(new ArrayList<>(), "categoria7", 2)
        );
        List<CategoryModel> levelThree = asList(categoryResponse(levelFour, "categoria4", 34));
        List<CategoryModel> levelTwo = asList(categoryResponse(levelThree, "categoria2", 35));
        return asList(categoryResponse(levelTwo, "categoria1", 4));

    }

    private List<CategoryModel> categories() {

        List<CategoryModel> levelFour = asList(categoryResponse(new ArrayList<>(), "categoria3", 2));
        List<CategoryModel> levelThree = asList(categoryResponse(levelFour, "categoria4", 1));
        List<CategoryModel> levelTwo = asList(categoryResponse(levelThree, "categoria2", 3));
        return asList(categoryResponse(levelTwo, "categoria1", 4));
    }

    private CategoryModel categoryResponse(List<CategoryModel> levelFour, String categoria4, int i) {
        CategoryModel categoryFour = new CategoryModel();
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
