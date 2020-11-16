package com.example.servicioAPI.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Category implements Comparable<Category>{
    private String id;
    private String name;
    private Integer relevance;
    private List<Category> subcategories;
    private String iconImageUrl;
    private String largeImageUrl;
    private String mediumImageUrl;
    private String smallImageUrl;
    private String image;

    public Category() {
    }

    public Category(String id, String name, Integer relevance, List<Category> subcategories, String iconImageUrl, String largeImageUrl, String mediumImageUrl, String smallImageUrl, String image) {
        this.id = id;
        this.name = name;
        this.relevance = relevance;
        this.subcategories = subcategories;
        this.iconImageUrl = iconImageUrl;
        this.largeImageUrl = largeImageUrl;
        this.mediumImageUrl = mediumImageUrl;
        this.smallImageUrl = smallImageUrl;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getRelevance() {
        return relevance;
    }

    public List<Category> getSubcategories() {
        return subcategories;
    }

    public String getIconImageUrl() {
        return iconImageUrl;
    }

    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    public String getMediumImageUrl() {
        return mediumImageUrl;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRelevance(Integer relevance) {
        this.relevance = relevance;
    }

    public void setSubcategories(List<Category> subcategories) {
        this.subcategories = subcategories;
    }

    public void setIconImageUrl(String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
    }

    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }

    public void setMediumImageUrl(String mediumImageUrl) {
        this.mediumImageUrl = mediumImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int compareTo(Category o) {
        return relevance.compareTo(o.getRelevance());
    }
}
