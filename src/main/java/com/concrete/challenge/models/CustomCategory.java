package com.concrete.challenge.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Detalle de modelo de salida final, modelo custom con �cono de la categor�a y una imagen peque�a. ")
public class CustomCategory {
	
	@ApiModelProperty(notes = "�cono de la categor�a")
	private String iconImageUrl;
	@ApiModelProperty(notes = "Imagen peque�a de la categor�a")
	private String smallImageUrl;
	@ApiModelProperty(notes = "Nombre de la categor�a")
	private String name;
	@ApiModelProperty(notes = "Relevancia de la categor�a")
    private Integer relevance;
	
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
	public String getIconImageUrl() {
		return iconImageUrl;
	}
	public void setIconImageUrl(String iconImageUrl) {
		this.iconImageUrl = iconImageUrl;
	}
	public String getSmallImageUrl() {
		return smallImageUrl;
	}
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
}
