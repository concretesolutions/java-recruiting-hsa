package com.desafio.entidades;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubcategoryLv3 extends BaseCategorie {

    private String largeImageUrl;
    private String mediumImageUrl;
    private String smallImageUrl;
    private List<SubcategoryLv4> subcategories;

    public SubcategoryLv3() {
    }


    public SubcategoryLv3( String smallImageUrl, List<SubcategoryLv4> subcategories) {
        this.smallImageUrl = smallImageUrl;
        this.subcategories = (ArrayList<SubcategoryLv4>) subcategories;
    }

    public SubcategoryLv3(String largeImageUrl, String mediumImageUrl, String smallImageUrl, List<SubcategoryLv4> subcategories) {
        this.largeImageUrl = largeImageUrl;
        this.mediumImageUrl = mediumImageUrl;
        this.smallImageUrl = smallImageUrl;
        this.subcategories = (ArrayList<SubcategoryLv4>)subcategories;
    }

    public SubcategoryLv3(String id, String name, int relevance, String largeImageUrl, String mediumImageUrl, String smallImageUrl, List<SubcategoryLv4> subcategories) {
        super(id, name, relevance);
        this.largeImageUrl = largeImageUrl;
        this.mediumImageUrl = mediumImageUrl;
        this.smallImageUrl = smallImageUrl;
        this.subcategories = (ArrayList<SubcategoryLv4>)subcategories;
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

    public List<SubcategoryLv4> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubcategoryLv4> subcategories) {
        this.subcategories = (ArrayList<SubcategoryLv4>)subcategories;
    }
}
