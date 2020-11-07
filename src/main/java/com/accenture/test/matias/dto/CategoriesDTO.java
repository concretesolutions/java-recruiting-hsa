package com.accenture.test.matias.dto;

import java.util.List;

import com.accenture.test.matias.model.Category;

import lombok.Data;

@Data
public class CategoriesDTO {

    List<Category> topCategories;
    List<Category> notopCategories;

}
