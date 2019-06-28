package com.concrete.categoria.dto;


public class SubcategoryLevel4DTO {
	
	String id;
	String name;
	Integer relevance;
	
	public SubcategoryLevel4DTO(String id, String name, Integer relevance) {
		super();
		this.id = id;
		this.name = name;
		this.relevance = relevance;
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

	

	
}
