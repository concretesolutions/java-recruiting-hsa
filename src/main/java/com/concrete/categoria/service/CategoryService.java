package com.concrete.categoria.service;

import com.concrete.categoria.dto.CategoryDTO;
import com.concrete.categoria.dto.CategoryThreeDTO;
import com.concrete.categoria.dto.SubcategoryLevel2DTO;
import com.concrete.categoria.dto.SubcategoryLevel3DTO;
import com.concrete.categoria.dto.SubcategoryLevel4DTO;

public interface CategoryService {
	
	public CategoryThreeDTO getCategoriesTree();
	public CategoryDTO getTop5Categories();
	public CategoryDTO getRemainingCategories();

	public CategoryDTO[] getCategoryList();
	public SubcategoryLevel2DTO[] getSubCategory2ListOfCategory(String idCategory);
	public SubcategoryLevel3DTO[] getSubCategory3ListOfSubCategory2(String idCategory, String idSubCat2);
	public SubcategoryLevel4DTO[] getSubCategory4ListOfSubCategory3(String idCategory, String idSubCat2, String idSubCat3);
	

}
