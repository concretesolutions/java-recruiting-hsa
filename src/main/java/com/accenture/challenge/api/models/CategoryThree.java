package com.accenture.challenge.api.models;

import java.util.List;

import lombok.Data;

@Data
public class CategoryThree {

	private String id;
	private String name;
	private int relevance;
	private List<Categories> subcategories;
}
