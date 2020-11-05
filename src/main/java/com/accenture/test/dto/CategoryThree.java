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
public class CategoryThree {

	private String id;
	private String name;
	private Integer relevance;
	private List<Categories> subcategories;
	
}
