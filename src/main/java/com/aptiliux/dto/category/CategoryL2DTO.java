package com.aptiliux.dto.category;

import java.util.List;
import java.util.stream.Stream;

import com.aptiliux.dto.json.view.Views;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryL2DTO implements Category {
	@JsonView(Views.Mobile.class)
    private String id;
	@JsonView(Views.Mobile.class)
    private String name;
	@JsonView(Views.Mobile.class)
    private Integer relevance;
	@JsonView(Views.Mobile.class)
    private String iconImageUrl;
	@JsonView(Views.Mobile.class)
    private List<CategoryL3DTO> subcategories;
    
    @Override
    public Stream<Category> flattened() {
    	return Stream.concat(
    			Stream.of(this),
    			subcategories.stream()
    				.flatMap(CategoryL3DTO::flattened));
    }
}