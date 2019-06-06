package com.concrete.challenge.models;

import java.util.ArrayList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Detalle de modelo de Subcategory_. ")
public class Subcategory_ {

	@ApiModelProperty(notes = "Identificador único del modelo de Subcategory_")
    private String id;
	@ApiModelProperty(notes = "Nombre del modelo de Subcategory_")
    private String name;
	@ApiModelProperty(notes = "Relevancia de la Subcategory_")
    private Integer relevance;
	@ApiModelProperty(notes = "Lista de subcategorias")
    private ArrayList<Subcategory__> subcategories = null;
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
	public Integer getRelevance() {
		return relevance;
	}
	public void setRelevance(Integer relevance) {
		this.relevance = relevance;
	}
	public ArrayList<Subcategory__> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(ArrayList<Subcategory__> subcategories) {
		this.subcategories = subcategories;
	}
	public String getIconImageUrl() {
		return iconImageUrl;
	}
	public void setIconImageUrl(String iconImageUrl) {
		this.iconImageUrl = iconImageUrl;
	}

}
