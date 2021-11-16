package com.concrete.javarecruitinghsa.dto.categorie;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor 
@Data
@EqualsAndHashCode(callSuper=true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategorieLevelTwo extends CategorieRoot {
	
	@Builder
	public CategorieLevelTwo(String id, String name, Integer relevance, String iconImageUrl,
			List<CategorieLevelThree> subCategories) {
		super(id, name, relevance);
		this.iconImageUrl = iconImageUrl;
		this.subCategories = subCategories;
	}
	
	String iconImageUrl;
	@JsonProperty("subcategories")
	List<CategorieLevelThree> subCategories;
}
