package com.accenture.service.impl;

import static java.util.Objects.isNull;

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

	/**
	 * consulta servicio y filtra categorias
	 */
	@Override
	public List<CategoryDTO> getTopFiveCategories() throws ServiceException, GenericNotFoundException {
		log.debug("getTopFiveCategories");
		this.list = new ArrayList<>();
		CategoryDTO resp = this.clientCategory.call();
		this.list = getCategories(resp);
		this.list = this.list.stream().filter(subCat -> subCat.getRelevance() <= 5 && subCat.getRelevance() > 0)
				.collect(Collectors.toList());
		this.list.sort(Comparator.comparingInt(CategoryDTO::getRelevance));
		return this.list;
	}

	/**
	 * consulta servicio y filtra categorias
	 */
	@Override
	public List<CategoryDTO> getRestOfCategories() throws ServiceException, GenericNotFoundException {
		log.debug("getRestOfCategories");
		this.list = new ArrayList<>();
		CategoryDTO resp = this.clientCategory.call();
		this.list = getCategories(resp);
		return this.list.stream().filter(subCat -> subCat.getRelevance() > 5 || subCat.getRelevance() == 0)
				.collect(Collectors.toList());
	}

	private List<CategoryDTO> getCategories(CategoryDTO cat) throws ServiceException, GenericNotFoundException {
		log.debug("getCategories");

		cat.getSubcategories().stream().forEach(c -> {
			if (!isNull(c)) {
				CategoryDTO catNew = new CategoryDTO();
				catNew.setId(c.getId());
				catNew.setName(c.getName());
				catNew.setRelevance(c.getRelevance());
				catNew.setSmallImageUrl(c.getSmallImageUrl());
				this.list.add(catNew);
				if (!(c.getSubcategories() == null)) {
					this.list.remove(list.size() - 1);
					c.getSubcategories().forEach(x -> {
						if (isNull(catNew.getSmallImageUrl())) {
							catNew.setSmallImageUrl(x.getSmallImageUrl());
						}
					});
					this.list.add(catNew);
					try {
						getCategories(c);
					} catch (Exception e) {
						log.error(e.getMessage());
					}
				}
			}
		});
		return this.list;
	}

}
