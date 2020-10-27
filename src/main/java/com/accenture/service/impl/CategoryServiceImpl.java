package com.accenture.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.client.ClientCategory;
import com.accenture.dto.CategoryDTO;
import com.accenture.exception.GenericNotFoundException;
import com.accenture.exception.ServiceException;
import com.accenture.service.CategoryService;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author
 *
 */
@Log4j2
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ClientCategory clientCategory;

	List<CategoryDTO> list = new ArrayList<>();

	@Override
	public List<CategoryDTO> getTopFiveCategories() throws ServiceException, GenericNotFoundException {
		log.debug("getTopFiveCategories");

		CategoryDTO resp = this.clientCategory.call();

		resp.getSubcategories().stream().forEach(x -> {
			this.list = x.getSubcategories().stream()
					.filter(subCat -> subCat.getRelevance() <= 5 && subCat.getRelevance() > 0)
					.collect(Collectors.toList());
		});
		this.list.sort(Comparator.comparingInt(CategoryDTO::getRelevance));
		return this.list;
	}

	@Override
	public List<CategoryDTO> getRestOfCategories() throws ServiceException, GenericNotFoundException {
		log.debug("getRestOfCategories");
		CategoryDTO resp = this.clientCategory.call();

		resp.getSubcategories().stream().forEach(x -> {
			this.list = x.getSubcategories().stream()
					.filter(subCat -> !(subCat.getRelevance() <= 5 && subCat.getRelevance() > 0))
					.collect(Collectors.toList());
		});
		return this.list;
	}

}
