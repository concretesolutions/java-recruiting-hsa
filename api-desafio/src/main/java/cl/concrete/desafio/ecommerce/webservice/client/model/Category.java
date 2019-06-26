package cl.concrete.desafio.ecommerce.webservice.client.model;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.ApiModelProperty;

public class Category {

	@ApiModelProperty(notes = "Category ID")
	private String id;
	@ApiModelProperty(notes = "Name of the category")
	private String name;
	@ApiModelProperty(notes = "Parent of the category (the current category can be a subcategory)")
	private String parentCategory;
	@ApiModelProperty(notes = "Position of the category")
	private Integer relevance;
	@ApiModelProperty(notes = "The image of the category in several formats")
	private Map<String, String> images;
	@ApiModelProperty(notes = "Icon of the category")
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
