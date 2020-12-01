
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
    "subcategories"
})
public class Category implements Serializable
{


	private static final long serialVersionUID = 2631382589691067661L;
	@JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("subcategories")
    private List<Subcategory> subcategories = new ArrayList<>();

    public Category() {
    }

    public Category(String id, String name, List<Subcategory> subcategories) {
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

    public Category withId(String id) {
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

    public Category withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("subcategories")
    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    @JsonProperty("subcategories")
    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    public Category withSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
        return this;
    }

    

}
