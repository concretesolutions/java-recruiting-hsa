package com.concrete.categoria.dto;


public class SubcategoryLevel2DTO {
	
	String id;
	String name;
	Integer relevance;
	String iconImageUrl;
	SubcategoryLevel3DTO[] subcategories;
	
	public SubcategoryLevel2DTO(String id, String name, Integer relevance, String iconImageUrl,
			SubcategoryLevel3DTO[] subcategories) {
		super();
		this.id = id;
		this.name = name;
		this.relevance = relevance;
		this.iconImageUrl = iconImageUrl;
		this.subcategories = subcategories;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRelevance() {
		return relevance;
	}
	public void setRelevance(Integer relevance) {
		this.relevance = relevance;
	}
	public String getIconImageUrl() {
		return iconImageUrl;
	}
	public void setIconImageUrl(String iconImageUrl) {
		this.iconImageUrl = iconImageUrl;
	}
	public SubcategoryLevel3DTO[] getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(SubcategoryLevel3DTO[] subcategories) {
		this.subcategories = subcategories;
	}
	
	
	
}
