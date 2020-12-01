
package cl.recruiting.hsa.proyecto.legacy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "subcategories"
})
public class Subcategory implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("subcategories")
    private List<SubcategoryPrimerNivel> subcategories = new ArrayList<>();
    @JsonIgnore


    public Subcategory() {
    }

    public Subcategory(String id, String name, List<SubcategoryPrimerNivel> subcategories) {
        super();
        this.id = id;
        this.name = name;
        this.subcategories = subcategories;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Subcategory withId(String id) {
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

    public Subcategory withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("subcategories")
    public List<SubcategoryPrimerNivel> getSubcategories() {
        return subcategories;
    }

    @JsonProperty("subcategories")
    public void setSubcategories(List<SubcategoryPrimerNivel> subcategories) {
        this.subcategories = subcategories;
    }

    public Subcategory withSubcategories(List<SubcategoryPrimerNivel> subcategories) {
        this.subcategories = subcategories;
        return this;
    }


}
