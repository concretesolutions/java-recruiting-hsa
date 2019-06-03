package com.desafio.entidades;

import java.util.List;

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

