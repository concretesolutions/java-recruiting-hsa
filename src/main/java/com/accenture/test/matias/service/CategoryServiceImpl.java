package com.accenture.test.matias.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.test.matias.client.CategoryClient;
import com.accenture.test.matias.dto.CategoriesDTO;
import com.accenture.test.matias.exception.ServiceUnavailableException;
import com.accenture.test.matias.model.Category;
import com.accenture.test.matias.util.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * Service that manage the categories.
 * 
 * @author Matias Gomez Arancibia.
 *
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    /**
     * Category clients that makes the api calls.
     */
    @Autowired
    private CategoryClient categoryClient;

    /**
     * {@inheritDoc}
     */
    @Override
    public CategoriesDTO getTopRelevanceCategories(int quantity) {

        log.trace("[CategoryService][getTopRelevanceCategories][{}] Inicio.", quantity);

        List<Category> categories = null;
        List<Category> topCategories = null;
        List<Category> noTopCategories = null;
        Category category = categoryClient.getCategories().getBody();
        if (category != null && !category.getSubcategories().isEmpty()) {
            categories = getCategoriesOrderedByRelevance(category);
            categories = doCustomCategoriesOperation(categories);
            topCategories = getTopCategories(categories, quantity);
            noTopCategories = getNoTopCategories(categories, quantity);
        }

        CategoriesDTO result = makeResponseResult(topCategories, noTopCategories);

        log.trace("[CategoryService][getTopRelevanceCategories][{}] Fin.", quantity);

        return result;
    }

    /**
     * Method that obtains the categories ordered by his relevance
     * (descendant).
     * 
     * @param category
     * @return
     */
    private List<Category> getCategoriesOrderedByRelevance(Category category) {

        List<Category> completeList = new ArrayList<Category>();
        addCategoryAndInsepct(category, completeList);
        return bubbleSortCategories(completeList);
    }

    /**
     * Method that do custom operations to categories, responding to rules of
     * the rest service.
     * 
     * @param categories Entire list of the categories.
     * @return Categories with the custom operations.
     */
    private List<Category> doCustomCategoriesOperation(List<Category> categories) {

        categories.forEach(cat -> {
            cat.setLargeImageUrl(null);
            cat.setMediumImageUrl(null);
        });

        return categories;
    }

    /**
     * Method that gets the first {quantity} categories of a list.
     * 
     * @param categories Complete list of categories.
     * @param quantity Quantity of categories to get from the start of the
     *        list.
     * @return Top {quantity} categories.
     */
    private List<Category> getTopCategories(List<Category> categories, int quantity) {

        return categories.stream().limit(quantity).collect(Collectors.toList());
    }

    /**
     * Method that gets the last {quantity} categories of a list.
     * 
     * @param categories Complete list of categories.
     * @param quantity Quantity of categories to get from the end of the list.
     * @return NoTop {quantity} categories.
     */
    private List<Category> getNoTopCategories(List<Category> categories, int quantity) {

        return categories.stream().skip(quantity).collect(Collectors.toList());

    }

    /**
     * Method that recursively adds simple categories (without the subcategory
     * field) to a list.
     * 
     * @param categoryToInspect
     * @param completeList
     */
    private void addCategoryAndInsepct(Category categoryToInspect, List<Category> completeList) {

        Category deepCopy = copyCategoryObject(categoryToInspect);
        deepCopy.setSubcategories(null);

        completeList.add(deepCopy);

        if (categoryToInspect.getSubcategories() != null && !categoryToInspect.getSubcategories().isEmpty()) {
            for (Category cat : categoryToInspect.getSubcategories()) {
                addCategoryAndInsepct(cat, completeList);
            }
        }
    }

    /**
     * Method that order a list of Category from higher relevance to lower.
     * 
     * @param completeList List with all the categories.
     * @return Return the list ordered.
     */
    private List<Category> bubbleSortCategories(List<Category> completeList) {

        List<Category> arr = completeList;
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j + 1).getRelevance() != null && (arr.get(j).getRelevance() == null
                        || arr.get(j).getRelevance() < arr.get(j + 1).getRelevance())) {
                    Category temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
        return arr;
    }

    /**
     * Method that return an copy of the object Category as input.
     * 
     * @param input Category to be copied.
     * @return Category deep copy.
     */
    private Category copyCategoryObject(Category input) {

        Category deepCopy;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            deepCopy = objectMapper.readValue(objectMapper.writeValueAsString(input), Category.class);
        } catch (JsonProcessingException e) {
            log.error("Error al copiar un objeto Category con ObjectMapper.", e);
            throw new ServiceUnavailableException("Error al convertir un objeto con ObjectMapper",
                    Constants.GENERIC_SOLUTION, "[addCategoryAndInsepct]");
        }
        return deepCopy;
    }

    /**
     * Method that makes the response of the rest service, with top-categories
     * and notop-categories.
     * 
     * @param topCategories Top categories
     * @param notopCategories Categories that are no top categories.
     * @return DTO with categories.
     */
    private CategoriesDTO makeResponseResult(List<Category> topCategories, List<Category> notopCategories) {

        CategoriesDTO response = new CategoriesDTO();
        response.setTopCategories(topCategories);
        response.setNotopCategories(notopCategories);
        return response;
    }

}
