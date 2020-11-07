package com.accenture.test.matias.model;

import java.util.List;

import lombok.Data;

@Data
public class Category {

    private String id;
    private String name;
    private Integer relevance;
    private String largeImageUrl;
    private String mediumImageUrl;
    private String smallImageUrl;
    private List<Category> subcategories;

}
