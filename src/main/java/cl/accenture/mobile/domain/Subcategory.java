
package cl.accenture.mobile.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author andrea.rojas.ruiz
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subcategory implements Serializable
{
	
	private final static long serialVersionUID = 7659310394652387672L;


    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("relevance")
    private Integer relevance;
    @JsonProperty("subcategories")
    private List<SubcategoryLevel2> subcategories = null;
    
   
    
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("relevance")
    public Integer getRelevance() {
        return relevance;
    }

    @JsonProperty("relevance")
    public void setRelevance(Integer relevance) {
        this.relevance = relevance;
    }

    @JsonProperty("subcategories")
    public List<SubcategoryLevel2> getSubcategories() {
        return subcategories;
    }

    @JsonProperty("subcategories")
    public void setSubcategories(List<SubcategoryLevel2> subcategories) {
        this.subcategories = subcategories;
    }

}