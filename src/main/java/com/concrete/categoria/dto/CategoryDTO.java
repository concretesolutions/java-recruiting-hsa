package com.concrete.categoria.dto;


public class CategoryDTO {
	
	String id;
	String name;
	Integer relevance;
	SubcategoryLevel2DTO[] subcategories;
	
	
	public CategoryDTO(String id, String name, Integer relevance, SubcategoryLevel2DTO[] subcategories) {
		super();
		this.id = id;
		this.name = name;
		this.relevance = relevance;
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
	public SubcategoryLevel2DTO[] getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(SubcategoryLevel2DTO[] subcategories) {
		this.subcategories = subcategories;
	}
	
	
}
