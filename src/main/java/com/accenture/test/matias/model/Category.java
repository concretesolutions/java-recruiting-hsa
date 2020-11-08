package com.accenture.test.matias.model;

import java.util.List;

import lombok.Data;

/**
 * Model class for a Category.
 * 
 * @author Matias Gomez Arancibia.
 *
 */
@Data
public class Category {

    /**
     * ID of the category.
     */
    private String id;

    /**
     * Name of the category.
     */
    private String name;

    /**
     * Relevance of the category.
     */
    private Integer relevance;

    /**
     * Large image url of the category
     */
    private String largeImageUrl;

    /**
     * Medium image url of the category.
     */
    private String mediumImageUrl;

    /**
     * Small image url of the category.
     */
    private String smallImageUrl;

    /**
     * Subcategories for this category.
     */
    private List<Category> subcategories;

}
