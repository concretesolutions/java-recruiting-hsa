package com.desafio.entidades;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategorieThree extends BaseCategorie {

    private List<Categories> subcategories;

    public CategorieThree() {
    }

    public CategorieThree(List<Categories> subcategories) {
        this.subcategories =(ArrayList<Categories>)subcategories;
    }

    public CategorieThree(String id, String name, int relevance, List<Categories> subcategories) {
        super(id, name, relevance);
        this.subcategories = (ArrayList<Categories>)subcategories;
    }

    public List<Categories> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Categories> subcategories) {
        this.subcategories = (ArrayList<Categories>)subcategories;
    }
}
