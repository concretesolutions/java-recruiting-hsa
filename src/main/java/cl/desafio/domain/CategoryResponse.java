package cl.desafio.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by yasna.bastias.pina on 19-10-2020.
 */
public class CategoryResponse {

    private String id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer relevance;
    private List<Subcategory> subcategories = null;

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

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }
}
