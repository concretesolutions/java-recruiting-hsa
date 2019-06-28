package com.concrete.categoria.service.imp;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concrete.categoria.dto.CategoryDTO;
import com.concrete.categoria.dto.CategoryThreeDTO;
import com.concrete.categoria.dto.SubcategoryLevel2DTO;
import com.concrete.categoria.dto.SubcategoryLevel3DTO;
import com.concrete.categoria.dto.SubcategoryLevel4DTO;
import com.concrete.categoria.service.CategoryService;
import com.concrete.categoria.service.ConsumeService;


@Component
public class CategoryServiceImp implements CategoryService {

	@Autowired
	ConsumeService consumeService;
	
	
	public CategoryThreeDTO getCategoriesTree() {
		
		return consumeService.getCategories();
		
		
	}
	
	@Override
	public CategoryDTO getTop5Categories() {
		
		CategoryThreeDTO categoryThreeDTO = consumeService.getCategories();
		CategoryDTO categoriesDTO = categoryThreeDTO.getSubcategories()[0];
		SubcategoryLevel2DTO[] subcategoryLevel2DTO = categoriesDTO.getSubcategories();
		
		Arrays.sort(subcategoryLevel2DTO, 
				(a,b) -> ((b.getRelevance() == null) ? (Integer)0 : b.getRelevance()).compareTo( (a.getRelevance() == null) ? 0 : a.getRelevance() )
				
				);		
		subcategoryLevel2DTO = Arrays.copyOfRange(subcategoryLevel2DTO, 0, 5);
		
		Arrays.stream(subcategoryLevel2DTO).forEach(u -> u.setSubcategories(null));
		
		categoriesDTO.setSubcategories(subcategoryLevel2DTO);
					
		return categoriesDTO;

	}

	@Override
	public CategoryDTO getRemainingCategories() {

		CategoryThreeDTO categoryThreeDTO = consumeService.getCategories();
		CategoryDTO categoriesDTO = categoryThreeDTO.getSubcategories()[0];
		SubcategoryLevel2DTO[] subcategoryLevel2DTO = categoriesDTO.getSubcategories();
		
		Arrays.sort(subcategoryLevel2DTO, 
				(a,b) -> ((b.getRelevance() == null) ? (Integer)0 : b.getRelevance()).compareTo( (a.getRelevance() == null) ? 0 : a.getRelevance() )
				
				);
		
		subcategoryLevel2DTO = Arrays.copyOfRange(subcategoryLevel2DTO, 5, subcategoryLevel2DTO.length);
		
		Arrays.stream(subcategoryLevel2DTO).forEach(u -> u.setSubcategories(null));
		
		categoriesDTO.setSubcategories(subcategoryLevel2DTO);
		
		return categoriesDTO;
	}

	
	@Override
	public CategoryDTO[] getCategoryList() {
		
		CategoryDTO[] categories= consumeService.getCategories().getSubcategories();
		
		return categories;
	}

	@Override
	public SubcategoryLevel2DTO[] getSubCategory2ListOfCategory(String idCategory) {

		
		Optional<CategoryDTO> category =  Arrays.stream(consumeService.getCategories().getSubcategories()).filter(x -> idCategory.equals(x.getId())).findFirst();
		
		if(category.isPresent()) {
			return category.get().getSubcategories();
		}
		else {
			return new SubcategoryLevel2DTO[0];
		}
		
	}

	@Override
	public SubcategoryLevel3DTO[] getSubCategory3ListOfSubCategory2(String idCategory, String idSubCat2) {
		
		CategoryDTO[] category = consumeService.getCategories().getSubcategories();
		
		Optional<CategoryDTO> categoryOp =  Arrays.stream(category).filter(x -> idCategory.equals(x.getId())).findFirst();
		
		if(!categoryOp.isPresent()) {
			return new SubcategoryLevel3DTO[0];
		}

		
		SubcategoryLevel2DTO[]  sub2 = categoryOp.get().getSubcategories();
		
		Optional<SubcategoryLevel2DTO> sub2Op = Arrays.stream(sub2).filter(x -> idSubCat2.equals(x.getId())).findFirst();
		
		if(!sub2Op.isPresent()) {
			return new SubcategoryLevel3DTO[0];
		}
		
		return sub2Op.get().getSubcategories();

	}

	@Override
	public SubcategoryLevel4DTO[] getSubCategory4ListOfSubCategory3(String idCategory, String idSubCat2, String idSubCat3) {
		
		CategoryDTO[] category = consumeService.getCategories().getSubcategories();
		
		Optional<CategoryDTO> categoryOp =  Arrays.stream(category).filter(x -> idCategory.equals(x.getId())).findFirst();
		
		if(!categoryOp.isPresent()) {
			return new SubcategoryLevel4DTO[0];
		}
		
		SubcategoryLevel2DTO[]  sub2 = categoryOp.get().getSubcategories();
		
		Optional<SubcategoryLevel2DTO> sub2Op = Arrays.stream(sub2).filter(x -> idSubCat2.equals(x.getId())).findFirst();
		
		if(!sub2Op.isPresent()) {
			return new SubcategoryLevel4DTO[0];
		}
		
		SubcategoryLevel3DTO[] sub3 = sub2Op.get().getSubcategories();
		
		Optional<SubcategoryLevel3DTO> sub3Op = Arrays.stream(sub3).filter(x -> idSubCat3.equals(x.getId())).findFirst();
		
		if(!sub3Op.isPresent()) {
			return new SubcategoryLevel4DTO[0];
		}
		
		return sub3Op.get().getSubcategories();
		
	}

	
	

	
}
