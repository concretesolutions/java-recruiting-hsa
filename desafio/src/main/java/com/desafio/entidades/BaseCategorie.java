package com.desafio.entidades;

public class BaseCategorie {

    private String id;
    private String name;
    private int relevance;

    public BaseCategorie() {
    }

    public BaseCategorie(String id, String name, int relevance) {
        this.id = id;
        this.name = name;
        this.relevance = relevance;
    }

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

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }
}
