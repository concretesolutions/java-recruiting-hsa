package cl.accenture.concrete.challenge.model;

import java.util.List;
import java.util.StringJoiner;

public class Category {
	
	//Common fields
	private String id;
	private String name;
	private long relevance;
	
	//Specific fields
	private String iconImageUrl;
	private String largeImageUrl;
	private String mediumImageUrl;
	private String smallImageUrl;
	
	//Subcategories Tree
	private List<Category> subcategories;

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

	public long getRelevance() {
		return relevance;
	}

	public void setRelevance(long relevance) {
		this.relevance = relevance;
	}

	public String getIconImageUrl() {
		return iconImageUrl;
	}

	public void setIconImageUrl(String iconImageUrl) {
		this.iconImageUrl = iconImageUrl;
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

	public List<Category> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<Category> subcategories) {
		this.subcategories = subcategories;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append("{");
		
		str.append("id: " + getId());
		str.append("name: " + getName());
		str.append("relevance: " + getRelevance());
		
		str.append("iconImageUrl: " + getIconImageUrl());
		str.append("largeImageUrl: " + getLargeImageUrl());
		str.append("mediumImageUrl: " + getMediumImageUrl());
		str.append("smallImageUrl: " + getSmallImageUrl());
		
		StringJoiner joiner = new StringJoiner(", ", "[", "]");
		
		subcategories.forEach(x -> {
			joiner.add(x.toString());
		});
		
		str.append("subcategories: " + joiner.toString());

		str.append("}");
		
		return str.toString();
	}

}
