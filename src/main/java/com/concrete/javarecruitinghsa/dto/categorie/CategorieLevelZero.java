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
public class CategorieLevelZero extends CategorieRoot{

	@Builder
	public CategorieLevelZero(String id, String name, Integer relevance, List<CategorieLevelOne> subCategories) {
		super(id, name, relevance);
		this.subCategories = subCategories;
	}

	@JsonProperty("subcategories")
	List<CategorieLevelOne> subCategories;
}
