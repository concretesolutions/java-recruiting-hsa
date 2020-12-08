package com.accenture.challenge.mapper;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category implements Comparable<Category>{

    private @Id @GeneratedValue String id;
    private String name;
    private int relevance;

    private String iconImageUrl;

    private String largeImageUrl;
    private String mediumImageUrl;
    private String smallImageUrl;

    private ArrayList<Category> subcategories = new ArrayList<Category>();

    public Integer getRelevance() {
        return this.relevance;
    }

    public ArrayList<Category> getSubCategories() {
        return this.subcategories;
    }

    @Override
    public int compareTo(Category category) {
        if (this.relevance > category.getRelevance()) {
            return -1;
        }
        if (this.relevance == category.getRelevance()) {
            return 0;
        } 
        return 1;
    }
}
