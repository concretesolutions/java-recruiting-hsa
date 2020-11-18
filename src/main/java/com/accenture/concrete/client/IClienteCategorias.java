package com.accenture.concrete.client;

import java.util.List;

import com.accenture.concrete.domain.Categories;

public interface IClienteCategorias {

	List<Categories> getCategorias();

	void clearCacheSchedule();

}
