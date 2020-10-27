package com.accenture.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonPropertyOrder({ "id", "name", "relevance", "smallImageUrl", "subcategories" })
@JsonInclude(value = Include.NON_DEFAULT, content = Include.NON_EMPTY)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Data
public class CategoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8609878665337183405L;
	private String id;
	private String name;
	private int relevance;
	private String smallImageUrl;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<CategoryDTO> subcategories;

}
