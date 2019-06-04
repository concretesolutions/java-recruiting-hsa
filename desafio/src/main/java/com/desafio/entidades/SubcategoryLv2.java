package com.desafio.entidades;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubcategoryLv2 extends BaseCategorie {

    private String iconImageUrl;
    private List<SubcategoryLv3> subcategories;

    public SubcategoryLv2() {
    }

    public SubcategoryLv2(String iconImageUrl, List<SubcategoryLv3> subcategories) {
        this.iconImageUrl = iconImageUrl;
        this.subcategories = (ArrayList<SubcategoryLv3>)subcategories;
    }

    public SubcategoryLv2(String id, String name, int relevance, String iconImageUrl, List<SubcategoryLv3> subcategories) {
        super(id, name, relevance);
        this.iconImageUrl = iconImageUrl;
        this.subcategories = (ArrayList<SubcategoryLv3>)subcategories;
    }

    public String getIconImageUrl() {
        return iconImageUrl;
    }

    public void setIconImageUrl(String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
    }

    public List<SubcategoryLv3> getSubcategories() {
        return subcategories;
    }

    public void setSubcategorie(List<SubcategoryLv3> subcategories) {
        this.subcategories = (ArrayList<SubcategoryLv3>) subcategories;
    }
}

