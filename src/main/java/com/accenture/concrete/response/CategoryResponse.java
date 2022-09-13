package com.accenture.concrete.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryResponse {

	private String id;
	private String name;
	private List<CategoryResponse> categories;
	private int relevance;
	private String smallImageUrl;
	
	@JsonCreator(mode = Mode.PROPERTIES)
	public CategoryResponse(
			@JsonProperty("id") String id, 
			@JsonProperty("name") String name, 
			@JsonProperty("subcategories") List<CategoryResponse> categories, 
			@JsonProperty("relevance") int relevance, 
			@JsonProperty("smallImageUrl") String smallImageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.categories = categories;
		this.relevance = relevance;
		this.smallImageUrl = smallImageUrl;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<CategoryResponse> getCategories() {
		return categories;
	}

	public int getRelevance() {
		return relevance;
	}

	public String getSmallImageUrl() {
		return smallImageUrl;
	}
	
}
