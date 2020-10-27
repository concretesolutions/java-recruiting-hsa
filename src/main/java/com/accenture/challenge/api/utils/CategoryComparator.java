package com.accenture.challenge.api.utils;

import java.util.Comparator;

import com.accenture.challenge.api.dto.CategoryDTO;

/**
 * Clase para ordenar la lista por el atributo Relevance usando Lambda
 * @author Manuel Gutierrez
 *
 */
public class CategoryComparator {
	
	public static Comparator<CategoryDTO> getCategoryComparatorByRelevance() {
		return (CategoryDTO o1, CategoryDTO o2) -> Integer.valueOf(o1.getRelevance()).compareTo( Integer.valueOf(o2.getRelevance()));
	}
}
