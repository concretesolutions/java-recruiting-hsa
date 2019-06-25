package cl.concrete.desafio.ecommerce.webservice.client.model;

import java.util.List;

public class CategoryDto {
	
	private String id;
	private String name;
	private String relevance;
	private String largeImageUrl;
	private String mediumImageUrl;
	private String smallImageUrl;
	private String iconImageUrl;
	private List<CategoryDto> subcategories;
	
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

	public String getIconImageUrl() {
		return iconImageUrl;
	}

	public void setIconImageUrl(String iconImageUrl) {
		this.iconImageUrl = iconImageUrl;
	}

	public String getRelevance() {
		return relevance;
	}

	public void setRelevance(String relevance) {
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

	public List<CategoryDto> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<CategoryDto> subcategories) {
		this.subcategories = subcategories;
	}
	
}
