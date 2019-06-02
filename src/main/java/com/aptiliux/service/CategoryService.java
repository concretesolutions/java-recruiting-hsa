package com.aptiliux.service;

import java.util.List;
import java.util.Optional;

import com.aptiliux.dto.category.Category;
import com.aptiliux.dto.category.CategoryDTO;

public interface CategoryService {

	Optional<CategoryDTO> getAllCategories();

	List<Category> getTopCategories(Long offset, Long limit);

}
