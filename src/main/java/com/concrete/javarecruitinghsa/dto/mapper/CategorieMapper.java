package com.concrete.javarecruitinghsa.dto.mapper;

import org.mapstruct.Mapper;

import com.concrete.javarecruitinghsa.dto.categorie.Categorie;
import com.concrete.javarecruitinghsa.dto.categorie.CategorieLevelFour;
import com.concrete.javarecruitinghsa.dto.categorie.CategorieLevelOne;
import com.concrete.javarecruitinghsa.dto.categorie.CategorieLevelThree;
import com.concrete.javarecruitinghsa.dto.categorie.CategorieLevelTwo;

@Mapper(componentModel = "spring")
public interface  CategorieMapper {

	Categorie categorieLvLOneToCategorie(CategorieLevelOne categorie);
	Categorie categorieLvLTwoToCategorie(CategorieLevelTwo categorie);
	Categorie categorieLvLThreeToCategorie(CategorieLevelThree categorie);
	Categorie categorieLvLFourToCategorie(CategorieLevelFour categorie);
	
}
