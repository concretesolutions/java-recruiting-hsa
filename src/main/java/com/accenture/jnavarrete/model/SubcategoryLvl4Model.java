package com.accenture.jnavarrete.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubcategoryLvl4Model {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("relevance")
    private Number relevance;

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
}
