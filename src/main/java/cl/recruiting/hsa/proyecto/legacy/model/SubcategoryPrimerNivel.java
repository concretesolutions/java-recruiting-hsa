
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
    "relevance",
    "subcategories",
    "iconImageUrl"
})
public class SubcategoryPrimerNivel implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("relevance")
    private int relevance;
    @JsonProperty("subcategories")

    private List<SubcategorySegundoNivel> subcategories = new ArrayList<>();
    @JsonProperty("iconImageUrl")
    private String iconImageUrl;
    

    public SubcategoryPrimerNivel() {
    }


    public SubcategoryPrimerNivel(String id, String name, int relevance, List<SubcategorySegundoNivel> subcategories, String iconImageUrl) {
        super();
        this.id = id;
        this.name = name;
        this.relevance = relevance;
        this.subcategories = subcategories;
        this.iconImageUrl = iconImageUrl;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public SubcategoryPrimerNivel withId(String id) {
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

    public SubcategoryPrimerNivel withName(String name) {
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

    public SubcategoryPrimerNivel withRelevance(int relevance) {
        this.relevance = relevance;
        return this;
    }

    @JsonProperty("subcategories")
    public List<SubcategorySegundoNivel> getSubcategories() {
        return subcategories;
    }

    @JsonProperty("subcategories")
    public void setSubcategories(List<SubcategorySegundoNivel> subcategories) {
        this.subcategories = subcategories;
    }

    public SubcategoryPrimerNivel withSubcategories(List<SubcategorySegundoNivel> subcategories) {
        this.subcategories = subcategories;
        return this;
    }

    @JsonProperty("iconImageUrl")
    public String getIconImageUrl() {
        return iconImageUrl;
    }

    @JsonProperty("iconImageUrl")
    public void setIconImageUrl(String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
    }

    public SubcategoryPrimerNivel withIconImageUrl(String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
        return this;
    }

   

}
