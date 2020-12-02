package cl.talavera.api.data;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.port.CategoryDaoPort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CategoryDao implements CategoryDaoPort {
    private final CategoryRestRepository repository;

    public CategoryDao(CategoryRestRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getTopCategories() {
        return SubCategoriesFrom(repository.getCategories());
    }


    private List<Category> SubCategoriesFrom(List<CategoryResponse> result) {
        List<Category> categories = new ArrayList<>();

        result.forEach(levelOne -> { add(categories, levelOne);
            levelOne.getSubcategories().forEach(levelTwo -> { add(categories, levelTwo);
                levelTwo.getSubcategories().forEach(levelThree -> { add(categories, levelThree);
                    levelThree.getSubcategories().forEach( levelFour ->{  add(categories, levelFour); });
                });
            });
        });


        return categories.stream()
                .sorted(Comparator.comparingInt(Category::getRelevance).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    private void add(List<Category> list, CategoryResponse response) {
        list.add(Category.builder()
                .name(response.getName())
                .relevance(response.getRelevance())
                .build());
    }
}
