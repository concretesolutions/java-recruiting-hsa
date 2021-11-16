package com.concrete.javarecruitinghsa.dto.categorie;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
public class CategorieLevelFour extends CategorieRoot {
	@Builder
	public CategorieLevelFour(String id, String name, Integer relevance) {
		super(id, name, relevance);
	}	
}

