package com.accenture.service;

import java.util.List;

import com.accenture.dto.CategoryDTO;
import com.accenture.exception.GenericNotFoundException;
import com.accenture.exception.ServiceException;

public interface CategoryService {

	List<CategoryDTO> getTopFiveCategories() throws ServiceException, GenericNotFoundException;

	List<CategoryDTO> getRestOfCategories() throws ServiceException, GenericNotFoundException;

}
