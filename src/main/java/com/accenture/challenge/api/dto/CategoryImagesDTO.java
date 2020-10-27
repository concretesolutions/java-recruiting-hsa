package com.accenture.challenge.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class CategoryImagesDTO {
	
	private String largeImageUrl;
	private String mediumImageUrl;
	private String smallImageUrl;

}
