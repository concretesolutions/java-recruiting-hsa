package com.accenture.test.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.test.dto.Category;
import com.accenture.test.dto.CategoryThree;
import com.accenture.test.exceptions.ResourceNotFoundException;
import com.accenture.test.feign.CategoriesFeignClient;
import com.accenture.test.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoriesFeignClient categoryClient;

	@Override
	public List<Category> getTopFive() {

		CategoryThree response;
		try {
			log.info("getTopFive()");
			response = categoryClient.getCategories();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Not found categories" + e);
		}

		List<Category> list = orderList(response);

		List<Category> listSorted = list.stream().sorted(Comparator.comparing(Category::getRelevance).reversed())
				.collect(Collectors.toList());

		List<Category> listTopFive = listSorted.stream().limit(5).collect(Collectors.toList());

		return listTopFive;
	}

	@Override
	public List<Category> getRemainingCategories() {

		CategoryThree response;
		try {
			log.info("getRemainingCategories()");
			response = categoryClient.getCategories();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Not found categories" + e);
		}

		List<Category> list = orderList(response);

		List<Category> listSorted = list.stream().sorted(Comparator.comparing(Category::getRelevance).reversed())
				.collect(Collectors.toList());

		List<Category> listRemaining = listSorted.stream().skip(5).collect(Collectors.toList());

		return listRemaining;
	}

	private List<Category> orderList(CategoryThree categoryThree) {

		List<Category> listFinal = new ArrayList<Category>();

		if (categoryThree != null) {
			Category cat = new Category();
			cat.setId(categoryThree.getId());
			cat.setName(categoryThree.getName());
			if (null != categoryThree.getRelevance()) {
				cat.setRelevance(categoryThree.getRelevance());
			}
			listFinal.add(cat);
		}

		categoryThree.getSubcategories().forEach(p -> {
			Category cat1 = new Category();
			cat1.setId(p.getId());
			cat1.setName(p.getName());
			if (null != p.getRelevance()) {
				cat1.setRelevance(p.getRelevance());
			}
			listFinal.add(cat1);
			p.getSubcategories().forEach(o -> {
				Category cat2 = new Category();
				cat2.setId(o.getId());
				cat2.setName(o.getName());
				if (null != o.getRelevance()) {
					cat2.setRelevance(o.getRelevance());
				}
				cat2.setIconImageUrl(o.getIconImageUrl());
				listFinal.add(cat2);
				o.getSubcategories().forEach(i -> {
					Category cat3 = new Category();
					cat3.setId(i.getId());
					cat3.setName(i.getName());
					if (null != i.getRelevance()) {
						cat3.setRelevance(i.getRelevance());
					}
					cat3.setSmallImageUrl(i.getSmallImageUrl());
					listFinal.add(cat3);
					i.getSubcategories().forEach(u -> {
						Category cat4 = new Category();
						cat4.setId(u.getId());
						cat4.setName(u.getName());
						if (null != u.getRelevance()) {
							cat4.setRelevance(u.getRelevance());
						}
						listFinal.add(cat4);
					});
				});
			});
		});

		return listFinal;
	}

}
