package cl.talavera.api.data.model;

import cl.talavera.api.core.domain.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryModel {
    private String id;
    private String name;
    private List<CategoryModel> subcategories;
    private int relevance;
    private String iconImageUrl;
    private String largeImageUrl;
    private String mediumImageUrl;
    private String smallImageUrl;


    public static Category category(CategoryModel response) {
        return Category.builder()
                .name(response.getName())
                .relevance(response.getRelevance())
                .large(response.getLargeImageUrl())
                .icon(response.getIconImageUrl())
                .build();
    }

}
