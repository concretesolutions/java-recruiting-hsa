package cl.desafio.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by yasna.bastias.pina on 19-10-2020.
 */
public class SubcategoryLvl3 {

    private String id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer relevance;
    private String largeImageUrl;
    private String mediumImageUrl;
    private String smallImageUrl;
    private List<SubcategoryLvl4> subcategories = null;

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

    public Integer getRelevance() {
        return relevance;
    }

    public void setRelevance(Integer relevance) {
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

    public List<SubcategoryLvl4> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubcategoryLvl4> subcategories) {
        this.subcategories = subcategories;
    }
}
