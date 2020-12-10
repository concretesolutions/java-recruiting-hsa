package com.accenture.jnavarrete.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SubcategoryLvl2Model {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("relevance")
    private Number relevance;
    @JsonProperty("iconImageUrl")
    private String iconImageUrl;
    @JsonProperty("subcategoryLvl3Model")
    private List<SubcategoryLvl3Model> subcategoryLvl3Model;

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

    public String getIconImageUrl() {
        return iconImageUrl;
    }

    public void setIconImageUrl(String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
    }

    public List<SubcategoryLvl3Model> getSubcategoryLvl3Model() {
        return subcategoryLvl3Model;
    }

    public void setSubcategoryLvl3Model(List<SubcategoryLvl3Model> subcategoryLvl3Model) {
        this.subcategoryLvl3Model = subcategoryLvl3Model;
    }
}
