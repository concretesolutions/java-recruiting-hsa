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
public class CategorieLevelThree extends CategorieRoot {
	
	@Builder
	public CategorieLevelThree(String id, String name, Integer relevance, String largeImageUrl, String mediumImageUrl,
			String smallImageUrl, List<CategorieLevelFour> subCategories) {
		super(id, name, relevance);
		this.largeImageUrl = largeImageUrl;
		this.mediumImageUrl = mediumImageUrl;
		this.smallImageUrl = smallImageUrl;
		this.subCategories = subCategories;
	}
	
	
	String largeImageUrl;
	String mediumImageUrl;
	String smallImageUrl;
	@JsonProperty("subcategories")
	List<CategorieLevelFour> subCategories;
}

