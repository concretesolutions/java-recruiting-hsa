
package cl.recruiting.hsa.proyecto.legacy.model;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "relevance"
})
public class SubcategoryTercerNivel implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("relevance")
    private int relevance;
    
    public SubcategoryTercerNivel() {
    }

    public SubcategoryTercerNivel(String id, String name, int relevance) {
        super();
        this.id = id;
        this.name = name;
        this.relevance = relevance;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public SubcategoryTercerNivel withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public SubcategoryTercerNivel withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("relevance")
    public int getRelevance() {
        return relevance;
    }

    @JsonProperty("relevance")
    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    public SubcategoryTercerNivel withRelevance(int relevance) {
        this.relevance = relevance;
        return this;
    }

    

}
