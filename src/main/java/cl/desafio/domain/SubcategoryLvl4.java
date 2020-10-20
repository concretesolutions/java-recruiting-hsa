package cl.desafio.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by yasna.bastias.pina on 19-10-2020.
 */
public class SubcategoryLvl4 {

    private String id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer relevance;

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
}
