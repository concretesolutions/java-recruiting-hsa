package com.concrete.challenge.models;

import java.util.ArrayList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Detalle de modelo de Subcategory. ")
public class Subcategory {
    
	@ApiModelProperty(notes = "Identificador único del modelo de Subcategory")
    private String id;
	@ApiModelProperty(notes = "Nombre del modelo de Subcategory")
    private String name;
	@ApiModelProperty(notes = "Lista de subcategorias")
    private ArrayList<Subcategory_> subcategories = null;
    
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
	public ArrayList<Subcategory_> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(ArrayList<Subcategory_> subcategories) {
		this.subcategories = subcategories;
	}

}
