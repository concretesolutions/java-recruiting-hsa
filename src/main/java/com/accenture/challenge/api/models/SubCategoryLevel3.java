package com.accenture.challenge.api.models;

import java.util.List;

import lombok.Data;

@Data
public class SubCategoryLevel3 {

	private String id;
	private String name;
	private int relevance;
	private String largeImageUrl;
	private String mediumImageUrl;
	private String smallImageUrl;
	private List<SubCategoryLevel4> subcategories;	
}
