package com.accenture.test.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubcategoryLevel3 {

	private String id;
	private String name;
	private Integer relevance;
	private String largeImageUrl;
	private String mediumImageUrl;
	private String smallImageUrl;
	private List<SubcategoryLevel4> subcategories;
}
