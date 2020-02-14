
package cl.accenture.mobile.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author andrea.rojas.ruiz
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubcategoryLevel2 implements Serializable
{
	
	private final static long serialVersionUID = 5830696586616860961L;

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("relevance")
    private Integer relevance;
    @JsonProperty("iconImageUrl")
    private String iconImageUrl;
    @JsonProperty("subcategories")
    private List<SubcategoryLevel3> subcategories = null;
   
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

    @JsonProperty("iconImageUrl")
    public String getIconImageUrl() {
        return iconImageUrl;
    }

    @JsonProperty("iconImageUrl")
    public void setIconImageUrl(String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
    }

    @JsonProperty("subcategories")
    public List<SubcategoryLevel3> getSubcategories() {
        return subcategories;
    }

    @JsonProperty("subcategories")
    public void setSubcategories(List<SubcategoryLevel3> subcategories) {
        this.subcategories = subcategories;
    }

 }