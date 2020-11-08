package com.accenture.test.matias.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Model class for a Category.
 * 
 * @author Matias Gomez Arancibia.
 *
 */
@Data
@JsonIgnoreProperties
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
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Integer relevance;

    /**
     * Large image url of the category
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String largeImageUrl;

    /**
     * Medium image url of the category.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String mediumImageUrl;

    /**
     * Small image url of the category.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String smallImageUrl;

    /**
     * Subcategories for this category.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    private List<Category> subcategories;

    /**
     * Icon image url of the category.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String iconImageUrl;

}
