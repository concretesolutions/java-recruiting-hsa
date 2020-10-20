package cl.desafio.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by yasna.bastias.pina on 19-10-2020.
 */
public class SubcategoryLvl2 {

    private String id;
    private String name;
    private int relevance;
    private String iconImageUrl;
    private List<SubcategoryLvl3> subcategories = null;

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

    public String getIconImageUrl() {
        return iconImageUrl;
    }

    public void setIconImageUrl(String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
    }

    public List<SubcategoryLvl3> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubcategoryLvl3> subcategories) {
        this.subcategories = subcategories;
    }
}
