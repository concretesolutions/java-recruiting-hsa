package com.concrete.categoria.dto;


public class SubcategoryLevel3DTO {

	String id;
	String name;
	Integer relevance;
	String largeImageUrl;
	String mediumImageUrl;
	String smallImageUrl;
	SubcategoryLevel4DTO[] subcategories;
	
	public SubcategoryLevel3DTO(String id, String name, Integer relevance, String largeImageUrl, String mediumImageUrl,
			String smallImageUrl, SubcategoryLevel4DTO[] subcategories) {
		super();
		this.id = id;
		this.name = name;
		this.relevance = relevance;
		this.largeImageUrl = largeImageUrl;
		this.mediumImageUrl = mediumImageUrl;
		this.smallImageUrl = smallImageUrl;
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
	public String getLargeImageUrl() {
		return largeImageUrl;
	}
	public void setLargeImageUrl(String largeImageUrl) {
		this.largeImageUrl = largeImageUrl;
	}
	public String getMediumImageUrl() {
		return mediumImageUrl;
	}
	public void setMediumImageUrl(String mediumImageUrl) {
		this.mediumImageUrl = mediumImageUrl;
	}
	public String getSmallImageUrl() {
		return smallImageUrl;
	}
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
	public SubcategoryLevel4DTO[] getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(SubcategoryLevel4DTO[] subcategories) {
		this.subcategories = subcategories;
	}
	
	
	
	
}
