package com.accenture.test.matias.dto;

import java.util.List;

import com.accenture.test.matias.model.Category;

import lombok.Data;

/**
 * Data transfer Object for the Categories separated by top-relevance input.
 * 
 * @author Matias Gomez Arancibia
 *
 */
@Data
public class CategoriesDTO {

    /**
     * Top categories.
     */
    private List<Category> topCategories;

    /**
     * The rest of categories that are not in top.
     */
    private List<Category> notopCategories;

}
