package cl.accenture.bff.categoriescoupons.service;

import cl.accenture.bff.categoriescoupons.client.CategoriesClient;
import cl.accenture.bff.categoriescoupons.dto.Category;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Copyright (c) 2023 Boris Molina
 */
@Service
public class CategoriesService {

    private final CategoriesClient categoriesClient;

    public CategoriesService(CategoriesClient categoriesClient) {
        this.categoriesClient = categoriesClient;
    }

    @Retryable(maxAttemptsExpression = "${retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "${retry.maxDelay}"))
    public Category getCategories() {
        return categoriesClient.getCategories();
    }

    @Retryable(maxAttemptsExpression = "${retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "${retry.maxDelay}"))
    public List<Category> getTop5Categories() {
        Category rootCategory = categoriesClient.getCategories();
        return getFirstFiveSubcategories(rootCategory);
    }

    public List<Category> getFirstFiveSubcategories(Category category) {
        if (category.getSubcategories() == null || category.getSubcategories().isEmpty()) {
            return Collections.emptyList();
        }
        return category.getSubcategories().stream()
                .flatMap(subcat -> subcat.getSubcategories().stream())
                .limit(5)
                .collect(Collectors.toList());
    }

}
