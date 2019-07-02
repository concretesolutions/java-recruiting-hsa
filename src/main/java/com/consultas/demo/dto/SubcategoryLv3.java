package com.consultas.demo.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Detalle de modelo de Subcategory__. ")
public class SubcategoryLv3 {

	@ApiModelProperty(notes = "Identificador único del modelo de Subcategory__")
    private String id;
	@ApiModelProperty(notes = "Nombre del modelo de Subcategory__")
    private String name;
	@ApiModelProperty(notes = "Lista de subcategorias")
    private List<SubcategoryLv4> subcategories = null;
    @ApiModelProperty(notes = "Imagen grande de la Subcategory__")
    private String largeImageUrl;
    @ApiModelProperty(notes = "Imagen mediana de la Subcategory__")
    private String mediumImageUrl;
    @ApiModelProperty(notes = "Imagen pequeña de la Subcategory__")
    private String smallImageUrl;
    @ApiModelProperty(notes = "Relevancia de la Subcategory__")
    private Integer relevance;
    
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
	public List<SubcategoryLv4> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(List<SubcategoryLv4> subcategories) {
		this.subcategories = subcategories;
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
	public Integer getRelevance() {
		return relevance;
	}
	public void setRelevance(Integer relevance) {
		this.relevance = relevance;
	}

}