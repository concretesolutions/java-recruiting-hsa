package cl.accenture.concrete.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Datos que posee una categoria
 * @author c.leon.palacios
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Categories implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6394100768962770725L;
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("relevance")
	private int relevance;
	@JsonProperty("subcategories")
	private List<Subcategory> subcategories;
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getRelevance() {
		return relevance;
	}
	public List<Subcategory> getSubcategories() {
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
	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}
}
