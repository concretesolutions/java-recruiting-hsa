package com.accenture.jnavarrete.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SubcategoryLvl3Model {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("relevance")
    private Number relevance;
    @JsonProperty("largeImageUrl")
    private String largeImageUrl;
    @JsonProperty("mediumImageUrl")
    private String mediumImageUrl;
    @JsonProperty("smallImageUrl")
    private String smallImageUrl;
    @JsonProperty("subcategoryLvl4Model")
    private List<SubcategoryLvl4Model> subcategoryLvl4Model;

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

    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }

    public String getMediumImageUrl() {
        return mediumImageUrl;
    }

    public void setMediumImageUrl(String mediumImageUrl) {
        this.mediumImageUrl = mediumImageUrl;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public List<SubcategoryLvl4Model> getSubcategoryLvl4Model() {
        return subcategoryLvl4Model;
    }

    public void setSubcategoryLvl4Model(List<SubcategoryLvl4Model> subcategoryLvl4Model) {
        this.subcategoryLvl4Model = subcategoryLvl4Model;
    }
}
