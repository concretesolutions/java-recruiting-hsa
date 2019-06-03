package com.desafio.entidades;

public class CategorieThree extends BaseCategorie {

    private Categories subcategories;

    public CategorieThree() {
    }

    public CategorieThree(Categories subcategories) {
        this.subcategories = subcategories;
    }

    public CategorieThree(String id, String name, int relevance, Categories subcategories) {
        super(id, name, relevance);
        this.subcategories = subcategories;
    }

    public Categories getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Categories subcategories) {
        this.subcategories = subcategories;
    }
}
