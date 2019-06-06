package com.concrete.challenge.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Detalle de modelo de salida final, modelo custom con ícono de la categoría y una imagen pequeña. ")
public class CustomCategory {
	
	@ApiModelProperty(notes = "ícono de la categoría")
	private String iconImageUrl;
	@ApiModelProperty(notes = "Imagen pequeña de la categoría")
	private String smallImageUrl;
	@ApiModelProperty(notes = "Nombre de la categoría")
	private String name;
	@ApiModelProperty(notes = "Relevancia de la categoría")
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
