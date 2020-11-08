package com.accenture.test.matias.service;

import com.accenture.test.matias.dto.CategoriesDTO;

/**
 * Service that manage the categories.
 * 
 * @author Matias Gomez Arancibia.
 *
 */
public interface CategoryService {

    /**
     * Method that gets the categories separated in top and notop.
     * 
     * @param quantity Quantity of top categories.
     * @return Categories in a DTO model.
     */
    public CategoriesDTO getTopRelevanceCategories(int quantity);

}
