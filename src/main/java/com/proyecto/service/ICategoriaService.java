package com.proyecto.service;

import java.util.List;

import com.proyecto.dto.Category;

public interface ICategoriaService {
	
	public Category obtener();
	
	public void filtrarImagenesMobile(List<Category> subcategories);
	
}
