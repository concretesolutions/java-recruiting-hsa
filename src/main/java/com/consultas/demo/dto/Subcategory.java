package com.consultas.demo.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Detalle de modelo de Subcategory. ")
public class Subcategory {
    
	@ApiModelProperty(notes = "Identificador único del modelo de Subcategory")
    private String id;
	@ApiModelProperty(notes = "Nombre del modelo de Subcategory")
    private String name;
	@ApiModelProperty(notes = "Lista de subcategorias")
    private List<SubcategoryLv2> subcategories = null;
    
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
	public List<SubcategoryLv2> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(List<SubcategoryLv2> subcategories) {
		this.subcategories = subcategories;
	}


}