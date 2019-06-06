package com.concrete.challenge.models;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Detalle de modelo de categorias. ")
public class CategoryResponse {

	@ApiModelProperty(notes = "Identificador único del modelo de categorias")
    private String id;
	@ApiModelProperty(notes = "Nombre del modelo de categorias")
    private String name;
	@ApiModelProperty(notes = "Lista de subcategorias")
    private List<Subcategory> subcategories = null;
    
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
	public List<Subcategory> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}

}
