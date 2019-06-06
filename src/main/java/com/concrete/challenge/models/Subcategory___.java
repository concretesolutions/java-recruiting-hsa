package com.concrete.challenge.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Detalle de modelo de Subcategoria___. ")
public class Subcategory___ {

	@ApiModelProperty(notes = "Identificador único del modelo de Subcategoria___")
    private String id;
	@ApiModelProperty(notes = "Nombre del modelo de Subcategoria___")
    private String name;
	@ApiModelProperty(notes = "Relevancia de la Subcategoria___")
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
	public Integer getRelevance() {
		return relevance;
	}
	public void setRelevance(Integer relevance) {
		this.relevance = relevance;
	}

}
