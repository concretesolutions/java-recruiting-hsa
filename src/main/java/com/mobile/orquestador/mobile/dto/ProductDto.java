package com.mobile.orquestador.mobile.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {

	private String id;
	private String name;
	private String smallImageUrl;
	private List<SubProductDto> subcategories;

}
