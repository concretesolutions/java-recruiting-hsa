package com.concrete.categoria.dto;


public class CategoryThreeDTO {
	
	String id;
	String name;
	String relevance;
	CategoryDTO[] subcategories;
	

	public CategoryThreeDTO(String id, String name, String relevance, CategoryDTO[] subcategories) {
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
	public String getRelevance() {
		return relevance;
	}
	public void setRelevance(String relevance) {
		this.relevance = relevance;
	}
	public CategoryDTO[] getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(CategoryDTO[] subcategories) {
		this.subcategories = subcategories;
	}
	
	
}
