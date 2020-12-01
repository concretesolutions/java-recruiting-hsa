
package cl.recruiting.hsa.proyecto.legacy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "subcategories",
    "largeImageUrl",
    "mediumImageUrl",
    "smallImageUrl",
    "relevance"
})
public class SubcategorySegundoNivel implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("subcategories")
    private List<SubcategoryTercerNivel> subcategories = new ArrayList<>();
    @JsonProperty("largeImageUrl")
    private String largeImageUrl;
    @JsonProperty("mediumImageUrl")
    private String mediumImageUrl;
    @JsonProperty("smallImageUrl")
    private String smallImageUrl;
    @JsonProperty("relevance")
    private int relevance;


    public SubcategorySegundoNivel() {
    }

    public SubcategorySegundoNivel(String id, String name, List<SubcategoryTercerNivel> subcategories, String largeImageUrl, String mediumImageUrl, String smallImageUrl, int relevance) {
        super();
        this.id = id;
        this.name = name;
        this.subcategories = subcategories;
        this.largeImageUrl = largeImageUrl;
        this.mediumImageUrl = mediumImageUrl;
        this.smallImageUrl = smallImageUrl;
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

    public SubcategorySegundoNivel withId(String id) {
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

    public SubcategorySegundoNivel withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("subcategories")
    public List<SubcategoryTercerNivel> getSubcategories() {
        return subcategories;
    }

    @JsonProperty("subcategories")
    public void setSubcategories(List<SubcategoryTercerNivel> subcategories) {
        this.subcategories = subcategories;
    }

    public SubcategorySegundoNivel withSubcategories(List<SubcategoryTercerNivel> subcategories) {
        this.subcategories = subcategories;
        return this;
    }

    @JsonProperty("largeImageUrl")
    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    @JsonProperty("largeImageUrl")
    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }

    public SubcategorySegundoNivel withLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
        return this;
    }

    @JsonProperty("mediumImageUrl")
    public String getMediumImageUrl() {
        return mediumImageUrl;
    }

    @JsonProperty("mediumImageUrl")
    public void setMediumImageUrl(String mediumImageUrl) {
        this.mediumImageUrl = mediumImageUrl;
    }

    public SubcategorySegundoNivel withMediumImageUrl(String mediumImageUrl) {
        this.mediumImageUrl = mediumImageUrl;
        return this;
    }

    @JsonProperty("smallImageUrl")
    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    @JsonProperty("smallImageUrl")
    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public SubcategorySegundoNivel withSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
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

    public SubcategorySegundoNivel withRelevance(int relevance) {
        this.relevance = relevance;
        return this;
    }

 
}
