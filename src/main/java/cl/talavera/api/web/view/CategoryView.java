package cl.talavera.api.web.view;

import cl.talavera.api.core.domain.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryView {
    private String name;
    private int relevance;
    private String small;
    private String large;
    private int level;

    public static CategoryView from(Category c) {
        return CategoryView.builder()
                .name(c.getName())
                .relevance(c.getRelevance())
                .small(c.getSmall())
                .large(c.getLarge())
                .level(c.getLevel())
                .build();
    }
}
