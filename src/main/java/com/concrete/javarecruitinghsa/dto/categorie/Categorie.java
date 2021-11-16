package com.concrete.javarecruitinghsa.dto.categorie;

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
public class Categorie extends CategorieRoot{	
	@Builder
	public Categorie(String id, String name, Integer relevance, String smallImageUrl, String iconImageUrl) {
		super(id, name, relevance);
		this.smallImageUrl = smallImageUrl;
		this.iconImageUrl = iconImageUrl;
	}
	
	String smallImageUrl;
	String iconImageUrl;
}
