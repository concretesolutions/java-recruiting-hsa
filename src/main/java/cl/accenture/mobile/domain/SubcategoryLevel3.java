
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
public class SubcategoryLevel3 implements Serializable
{
	private final static long serialVersionUID = -8626448638781221180L;

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("relevance")
    private Integer relevance;
    @JsonProperty("largeImageUrl")
    private String largeImageUrl;
    @JsonProperty("mediumImageUrl")
    private String mediumImageUrl;
    @JsonProperty("smallImageUrl")
    private String smallImageUrl;
    @JsonProperty("subcategories")
    private List<SubcategoryLevel4> subcategories = null;
   
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

    @JsonProperty("largeImageUrl")
    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    @JsonProperty("largeImageUrl")
    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }

    @JsonProperty("mediumImageUrl")
    public String getMediumImageUrl() {
        return mediumImageUrl;
    }

    @JsonProperty("mediumImageUrl")
    public void setMediumImageUrl(String mediumImageUrl) {
        this.mediumImageUrl = mediumImageUrl;
    }

    @JsonProperty("smallImageUrl")
    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    @JsonProperty("smallImageUrl")
    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    @JsonProperty("subcategories")
    public List<SubcategoryLevel4> getSubcategories() {
        return subcategories;
    }

    @JsonProperty("subcategories")
    public void setSubcategories(List<SubcategoryLevel4> subcategories) {
        this.subcategories = subcategories;
    }

}