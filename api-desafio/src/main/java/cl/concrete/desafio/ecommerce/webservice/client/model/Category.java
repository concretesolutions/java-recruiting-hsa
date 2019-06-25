package cl.concrete.desafio.ecommerce.webservice.client.model;

import java.util.HashMap;
import java.util.Map;

public class Category {

	private String id;
	private String name;
	private String parentCategory;
	private Integer relevance;
	private Map<String, String> images;
	private String iconImage;
	
	public Category() {
		this.images = new HashMap<String, String>();
		this.images.put("large", "");
		this.images.put("medium", "");
		this.images.put("small", "");
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

	public String getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Integer getRelevance() {
		return relevance;
	}

	public void setRelevance(Integer relevance) {
		this.relevance = relevance;
	}

	public Map<String, String> getImages() {
		return images;
	}

	public void setImages(Map<String, String> images) {
		this.images = images;
	}

	public String getIconImage() {
		return iconImage;
	}

	public void setIconImage(String iconImage) {
		this.iconImage = iconImage;
	}
	
}
