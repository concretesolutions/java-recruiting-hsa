package com.concrete.javarecruitinghsa.dto.categorie;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@Data
@EqualsAndHashCode(callSuper=true)
public class CategorieLevelOne extends CategorieRoot {
	
	@Builder
	public CategorieLevelOne(String id, String name, Integer relevance, List<CategorieLevelTwo> subCategories) {
		super(id, name, relevance);
		this.subCategories = subCategories;
	}

	@JsonProperty("subcategories")
	List<CategorieLevelTwo> subCategories;
}
