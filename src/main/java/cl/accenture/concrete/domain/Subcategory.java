package cl.accenture.concrete.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Subcategoria nivel 1
 * @author c.leon.palacios
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subcategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -764584401182443443L;
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("relevance")
	private int relevance;
	@JsonProperty("subcategories")
	private List<Subcategory2> subcategories;
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getRelevance() {
		return relevance;
	}
	public List<Subcategory2> getSubcategories() {
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
	public void setSubcategories(List<Subcategory2> subcategories) {
		this.subcategories = subcategories;
	}
}
