package com.desafio.entidades;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubcategoryLv2 extends BaseCategorie {

    private String iconImageUrl;
    private List<SubcategoryLv3> subcategorie;

    public SubcategoryLv2() {
    }

    public SubcategoryLv2(String iconImageUrl, List<SubcategoryLv3> subcategorie) {
        this.iconImageUrl = iconImageUrl;
        this.subcategorie = (ArrayList<SubcategoryLv3>)subcategorie;
    }

    public SubcategoryLv2(String id, String name, int relevance, String iconImageUrl, List<SubcategoryLv3> subcategorie) {
        super(id, name, relevance);
        this.iconImageUrl = iconImageUrl;
        this.subcategorie = (ArrayList<SubcategoryLv3>)subcategorie;
    }

    public String getIconImageUrl() {
        return iconImageUrl;
    }

    public void setIconImageUrl(String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
    }

    public List<SubcategoryLv3> getSubcategorie() {
        return subcategorie;
    }

    public void setSubcategorie(List<SubcategoryLv3> subcategorie) {
        this.subcategorie = (ArrayList<SubcategoryLv3>) subcategorie;
    }
}

