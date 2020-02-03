package cl.accenture.concrete.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Subcategoria nivel 3
 * @author c.leon.palacios
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subcategory3 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8213870571905913455L;
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("relevance")
	private int relevance;
	@JsonProperty("largeImageUrl")
	private String largeImageUrl;
	@JsonProperty("mediumImageUrl")
	private String mediumImageUrl;
	@JsonProperty("smallImageUrl")
	private String smallImageUrl;
	@JsonProperty("subcategories")
	private List<Subcategory4> subcategories;
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getRelevance() {
		return relevance;
	}
	public String getLargeImageUrl() {
		return largeImageUrl;
	}
	public String getMediumImageUrl() {
		return mediumImageUrl;
	}
	public String getSmallImageUrl() {
		return smallImageUrl;
	}
	public List<Subcategory4> getSubcategories() {
		return subcategories;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRelevance(int relevance) {
		this.relevance = relevance;
	}
	public void setLargeImageUrl(String largeImageUrl) {
		this.largeImageUrl = largeImageUrl;
	}
	public void setMediumImageUrl(String mediumImageUrl) {
		this.mediumImageUrl = mediumImageUrl;
	}
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
	public void setSubcategories(List<Subcategory4> subcategories) {
		this.subcategories = subcategories;
	}
}
