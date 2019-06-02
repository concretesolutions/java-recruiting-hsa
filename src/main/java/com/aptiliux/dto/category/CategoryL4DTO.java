package com.aptiliux.dto.category;

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
public class CategoryL4DTO implements Category {
	@JsonView(Views.Mobile.class)
    private String id;
	@JsonView(Views.Mobile.class)
    private String name;
	@JsonView(Views.Mobile.class)
    private Integer relevance;
}
