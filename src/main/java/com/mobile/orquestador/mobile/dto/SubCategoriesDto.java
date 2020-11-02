package com.mobile.orquestador.mobile.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SubCategoriesDto {
	
	private int relevance;
	private String id;
	private String name;
	private List<ProductDto> subcategories;

}
