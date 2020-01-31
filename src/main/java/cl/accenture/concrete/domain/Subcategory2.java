package cl.accenture.concrete.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subcategory2 implements Serializable {

	/**
	 * @author juan.horta.lucero
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("relevance")
	private int relevance;
	@JsonProperty("iconImageUrl")
	private String iconImageUrl;
	@JsonProperty("subcategories")
	private List<Subcategory3> subcategories;
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getRelevance() {
		return relevance;
	}
	public String getIconImageUrl() {
		return iconImageUrl;
	}
	public List<Subcategory3> getSubcategories() {
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
	public void setIconImageUrl(String iconImageUrl) {
		this.iconImageUrl = iconImageUrl;
	}
	public void setSubcategories(List<Subcategory3> subcategories) {
		this.subcategories = subcategories;
	}
}
