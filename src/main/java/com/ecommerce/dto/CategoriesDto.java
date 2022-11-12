package com.ecommerce.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class CategoriesDto implements Serializable {
	
	private static final long serialVersionUID = -1859040533319404780L;
	private String id;
	private String name;
	private int relevance;
	private String smallImageUrl;
	private String iconImageUrl;
	private List<CategoriesDto> subcategories;

}
