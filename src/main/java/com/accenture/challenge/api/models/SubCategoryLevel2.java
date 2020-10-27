package com.accenture.challenge.api.models;

import java.util.List;

import lombok.Data;

@Data
public class SubCategoryLevel2{

	private String id;
	private String name;
	private int relevance;
	private String iconImageUrl;
	private List<SubCategoryLevel3> subcategories;
	
}
