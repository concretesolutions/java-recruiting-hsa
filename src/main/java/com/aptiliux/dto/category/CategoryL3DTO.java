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
public class CategoryL3DTO implements Category {
	@JsonView(Views.Mobile.class)
	private String id;
	@JsonView(Views.Mobile.class)
    private String name;
	@JsonView(Views.Mobile.class)
    private Integer relevance;
    private String largeImageUrl;
    private String mediumImageUrl;
    @JsonView(Views.Mobile.class)
    private String smallImageUrl;
    @JsonView(Views.Mobile.class)
    private List<CategoryL4DTO> subcategories;
    
    @Override
    public Stream<Category> flattened() {
    	return Stream.concat(
    			Stream.of(this),
    			subcategories.stream()
    				.flatMap(CategoryL4DTO::flattened));
    }
}