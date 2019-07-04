package com.desafio.concrete.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Detalle de modelo de Subcategory_. ")
public class SubcategoryLv2 {

	@ApiModelProperty(notes = "Identificador único del modelo de Subcategory_")
    private String id;
	@ApiModelProperty(notes = "Nombre del modelo de Subcategory_")
    private String name;
	@ApiModelProperty(notes = "Relevancia de la Subcategory_")
    private int relevance;
	@ApiModelProperty(notes = "Lista de subcategorias")
    private List<SubcategoryLv3> subcategories = null;
    @ApiModelProperty(notes = "ícono de la Subcategory_")
    private String iconImageUrl;
    
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
	public List<SubcategoryLv3> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(List<SubcategoryLv3> subcategories) {
		this.subcategories = subcategories;
	}
	public String getIconImageUrl() {
		return iconImageUrl;
	}
	public void setIconImageUrl(String iconImageUrl) {
		this.iconImageUrl = iconImageUrl;
	}

}
