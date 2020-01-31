package cl.accenture.concrete.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCategory implements Comparable<Object>{

	/**
	 * @author juan.horta.lucero
	 */
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("relevance")
	private int relevance;
	@JsonProperty("smallImageUrl")
	private String smallImageUrl;
	@JsonProperty("iconImageUrl")
	private String iconImageUrl;
	
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
	
	@Override
	public int compareTo(Object o) {
		return (this.getRelevance() < ((ResponseCategory) o).getRelevance() ? -1 : (this.getRelevance() == ((ResponseCategory) o).getRelevance() ? 0 : 1));
	}
	public String getSmallImageUrl() {
		return smallImageUrl;
	}
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
	public String getIconImageUrl() {
		return iconImageUrl;
	}
	public void setIconImageUrl(String iconImageUrl) {
		this.iconImageUrl = iconImageUrl;
	}
}
