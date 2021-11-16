package com.concrete.javarecruitinghsa.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concrete.javarecruitinghsa.dto.categorie.Categorie;
import com.concrete.javarecruitinghsa.dto.mapper.CategorieMapper;
import com.concrete.javarecruitinghsa.restclient.CategorieRestClient;

@Service
public class CategorieService{

	@Autowired
	private CategorieRestClient categorieRestClient;
	@Autowired
	private CategorieMapper categorieMapper;
	
	public List<Categorie> getCarrousel() {
		List<Categorie> categories = getCategoriesOrderedByRelevance(); 
		return categories.stream().limit( categories.size() < 5? (categories.size()-1): 5 ).collect( Collectors.toList() );
	}
	
	public List<Categorie> getGrid() {
		List<Categorie> categories = getCategoriesOrderedByRelevance();  
		return categories.stream().skip( categories.size() < 5? (categories.size()-1): 5 ).collect( Collectors.toList() );
	}
	
	public List<Categorie> getCategoriesOrderedByRelevance(){
		List<Categorie> categories = new ArrayList<>();
		categorieRestClient.getCategories().getSubCategories().forEach( lvlOne -> {			
			lvlOne.getSubCategories().forEach( lvlTwo -> {				
				lvlTwo.getSubCategories().forEach( lvlThree -> {				
					lvlThree.getSubCategories().forEach( lvlFour -> {						
						categories.add(categorieMapper.categorieLvLFourToCategorie(lvlFour));						
					});					
					categories.add(categorieMapper.categorieLvLThreeToCategorie(lvlThree));					
				});				
				categories.add(categorieMapper.categorieLvLTwoToCategorie(lvlTwo));
			});			
		});
		
		categories.sort(Comparator.comparing( Categorie::getRelevance, Comparator.nullsLast(Comparator.reverseOrder()) ));
		return categories;
	}
	
}
