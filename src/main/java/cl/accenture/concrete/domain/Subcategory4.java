package cl.accenture.concrete.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Subcategoria nivel 4
 * @author c.leon.palacios
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subcategory4 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3164160289914738824L;
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("relevance")
	private int relevance;
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getRelevance() {
		return relevance;
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
}
