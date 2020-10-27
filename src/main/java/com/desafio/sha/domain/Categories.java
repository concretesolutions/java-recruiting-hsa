package com.desafio.sha.domain;

import java.util.List;

public class Categories {
	private String id;
	private String name;
	private int relevance;
	private String iconImageUrl;
	private String mediumImageUrl;
	private String smallImageUrl;
	private List<Categories> subcategories;

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

	public int getRelevance() {
		return relevance;
	}

	public void setRelevance(int relevance) {
		this.relevance = relevance;
	}

	public String getIconImageUrl() {
		return iconImageUrl;
	}

	public void setIconImageUrl(String iconImageUrl) {
		this.iconImageUrl = iconImageUrl;
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

	public List<Categories> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<Categories> subcategories) {
		this.subcategories = subcategories;
	}

	@Override
	public String toString() {
		return "Categories [id=" + id + ", name=" + name + ", relevance=" + relevance + ", iconImageUrl=" + iconImageUrl
				+ ", mediumImageUrl=" + mediumImageUrl + ", smallImageUrl=" + smallImageUrl + "]";
	}

	
	
}
