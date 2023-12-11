package cl.accenture.bff.categoriescoupons.dto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * Copyright (c) 2023 Boris Molina
 */
public class CategoryTest {

    @Test
    public void testCategory() {
        Category subcategory = new Category();
        Category category = Category.builder()
                .id("123")
                .name("Name")
                .relevance(1)
                .iconImageUrl("iconUrl")
                .largeImageUrl("largeUrl")
                .mediumImageUrl("mediumUrl")
                .smallImageUrl("smallUrl")
                .subcategories(List.of(subcategory))
                .build();

        assertThat(category.getId()).isEqualTo("123");
        assertThat(category.getName()).isEqualTo("Name");
        assertThat(category.getRelevance()).isEqualTo(1);
        assertThat(category.getIconImageUrl()).isEqualTo("iconUrl");
        assertThat(category.getLargeImageUrl()).isEqualTo("largeUrl");
        assertThat(category.getMediumImageUrl()).isEqualTo("mediumUrl");
        assertThat(category.getSmallImageUrl()).isEqualTo("smallUrl");
        List<Category> subcategories = category.getSubcategories();
        assertThat(subcategories).isNotEmpty();
        assertThat(subcategories).hasSize(1);
        assertThat(subcategories.get(0)).isEqualTo(subcategory);
    }

}
