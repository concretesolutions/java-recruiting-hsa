package com.accenture.challenge.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SubCategoryDTO {
	
	private String id;
	private String name;
	private int relevance;
	private CategoryImagesDTO categoryImages;
	private List<SubCategoryDTO> details;
}
