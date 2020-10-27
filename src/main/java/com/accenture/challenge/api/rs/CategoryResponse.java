package com.accenture.challenge.api.rs;

import java.util.List;

import com.accenture.challenge.api.dto.CategoryDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class CategoryResponse {
	
	private Status serviceStatus;
	private List<CategoryDTO> categories;
	private List<CategoryDTO> categoriesRemaider;
	private String status;

}
