package com.desafio.entidades;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Categories extends BaseCategorie {

    private List<SubcategoryLv2> subcategories;

    public Categories() {
    }

    public Categories(List<SubcategoryLv2> subcategories) {
        this.subcategories = subcategories;
    }

    public Categories(String id, String name, int relevance, List<SubcategoryLv2> subcategories) {
        super(id, name, relevance);
        this.subcategories = subcategories;
    }

    public List<SubcategoryLv2> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubcategoryLv2> subcategories) {
        this.subcategories = subcategories;
    }
}

