package com.accenture.challenge.api.models;

import java.util.List;

import lombok.Data;

@Data
public class Categories {

	private String id;
	private String name;
	private int relevance;
	private List<SubCategoryLevel2> subcategories;
}
