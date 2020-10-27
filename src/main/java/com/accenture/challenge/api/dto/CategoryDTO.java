package com.accenture.challenge.api.dto;

import java.util.List;

import lombok.Data;

@Data
public class CategoryDTO {
	
	private String id;
	private String name;
	private int relevance;
	private String iconImageUrl;
	private List<SubCategoryDTO> subCategories;

}
