package com.accenture.jnavarrete.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CategoriesModel {

    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("relevance")
    public Number relevance;
    @JsonProperty("subcategoryLvl2Model")
    private List<SubcategoryLvl2Model> subcategoryLvl2Model;

    /* Getter and Setter */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getRelevance() {
        return relevance;
    }

    public void setRelevance(Number relevance) {
        this.relevance = relevance;
    }

    public List<SubcategoryLvl2Model> getSubcategoryLvl2Model() {
        return subcategoryLvl2Model;
    }

    public void setSubcategoryLvl2Model(List<SubcategoryLvl2Model> subcategoryLvl2Model) {
        this.subcategoryLvl2Model = subcategoryLvl2Model;
    }
}
