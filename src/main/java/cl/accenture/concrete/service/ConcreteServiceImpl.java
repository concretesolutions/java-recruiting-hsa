package cl.accenture.concrete.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.accenture.concrete.domain.Categories;
import cl.accenture.concrete.domain.ResponseCategory;
import cl.accenture.concrete.domain.ResponseCoupon;
import cl.accenture.concrete.domain.Subcategory;
import cl.accenture.concrete.domain.Subcategory2;
import cl.accenture.concrete.domain.Subcategory3;
import cl.accenture.concrete.domain.Subcategory4;
import cl.accenture.concrete.exception.ApiServerException;
import cl.accenture.concrete.feing.api.client.CategoriesClient;
import cl.accenture.concrete.feing.api.client.CouponsClient;
import cl.accenture.concrete.service.interfaces.ConcreteService;

@Service
public class ConcreteServiceImpl implements ConcreteService{

private static final Logger logger = LoggerFactory.getLogger(ConcreteServiceImpl.class);
	
	@Autowired
	CategoriesClient categoriesClient;
	
	@Autowired
	CouponsClient couponsClient;

	@Override
	public List<ResponseCategory> getTopFive() {
		logger.info("getTopFive - IN");
		List<ResponseCategory> listTop5Categories = new ArrayList<>();
		
		
		try
		{
			Categories categories = categoriesClient.getAllCategories();
			List<ResponseCategory> listCategories = getListCategories(categories);
			
			List<ResponseCategory> sortedList = listCategories.stream()
					.sorted(Comparator.comparing(ResponseCategory::getRelevance).reversed())
					.collect(Collectors.toList());
			
			listTop5Categories = sortedList.stream().limit(5).collect(Collectors.toList());

		}catch (Exception e) {
			throw new ApiServerException(e);
		}finally {
			logger.info("getTopFive - OUT");
		}
		return listTop5Categories;
	}
	
	@Override
	public List<ResponseCategory> getRemaining() {
		logger.info("getRemaining - IN");
		List<ResponseCategory> listRemaining = new ArrayList<>();
		try
		{
			Categories categories = categoriesClient.getAllCategories();
			List<ResponseCategory> listCategories = getListCategories(categories);
			
			List<ResponseCategory> sortedList = listCategories.stream()
					.sorted(Comparator.comparing(ResponseCategory::getRelevance).reversed())
					.collect(Collectors.toList());
			
			listRemaining = sortedList.stream().skip(5).collect(Collectors.toList());

		}catch (Exception e) {
			throw new ApiServerException(e);
		}finally {
			logger.info("getRemaining - OUT");
		}
		return listRemaining;
	}

	@Override
	public List<ResponseCoupon> getValidsCoupons() {
		logger.info("getValidsCoupons - IN");
		List<ResponseCoupon> validCoupons = new ArrayList<>();
		try
		{
			List<ResponseCoupon> allCoupons = couponsClient.getAllCoupons();
			validCoupons = allCoupons.stream().filter(c-> c.isValidDate()).collect(Collectors.toList());
		}
		catch (Exception e) {
			throw new ApiServerException(e);
		}finally {
			logger.info("getValidsCoupons - OUT");
		}
		return validCoupons;
	}
	
	private List<ResponseCategory> getListCategories(Categories categories)
	{
		List<ResponseCategory> listCategories = new ArrayList<>();
		int subCategorySize = categories.getSubcategories().size();
		addCategoryToList(listCategories, categories);
		for(int i=0;i<subCategorySize;i++)
		{
			Subcategory subcategory = categories.getSubcategories().get(i);
			addCategoryToList(listCategories, subcategory);
			
			int subcategorySize = subcategory.getSubcategories().size();
			for(int e=0;e<subcategorySize;e++)
			{
				Subcategory2 subcategory2 = subcategory.getSubcategories().get(e);
				addCategoryToList(listCategories, subcategory2);
				
				int subcategory2Size = subcategory2.getSubcategories().size();
				for(int j=0;j<subcategory2Size;j++)
				{
					Subcategory3 subcategory3 = subcategory2.getSubcategories().get(j);
					addCategoryToList(listCategories, subcategory3);
					
					int subcategory3Size = subcategory3.getSubcategories().size();
					for(int h=0;h<subcategory3Size;h++)
					{
						Subcategory4 subcategory4 = subcategory3.getSubcategories().get(h);
						addCategoryToList(listCategories, subcategory4);
					}
				}
			}
		}
		return listCategories;
	}

	private void addCategoryToList(List<ResponseCategory> list, Object category)
	{
		ResponseCategory responseCategory = new ResponseCategory();
		if(category instanceof Categories)
		{
			Categories categories = (Categories) category;
			responseCategory.setId(categories.getId());
			responseCategory.setName(categories.getName());
			responseCategory.setRelevance(categories.getRelevance());
		}
		else if(category instanceof Subcategory)
		{
			Subcategory subcategory = (Subcategory) category;
			responseCategory.setId(subcategory.getId());
			responseCategory.setName(subcategory.getName());
			responseCategory.setRelevance(subcategory.getRelevance());
		}
		else if(category instanceof Subcategory2)
		{
			Subcategory2 subcategory2 = (Subcategory2) category;
			responseCategory.setId(subcategory2.getId());
			responseCategory.setName(subcategory2.getName());
			responseCategory.setRelevance(subcategory2.getRelevance());
			responseCategory.setIconImageUrl(subcategory2.getIconImageUrl());
		}
		else if(category instanceof Subcategory3)
		{
			Subcategory3 subcategory3 = (Subcategory3) category;
			responseCategory.setId(subcategory3.getId());
			responseCategory.setName(subcategory3.getName());
			responseCategory.setRelevance(subcategory3.getRelevance());
			responseCategory.setSmallImageUrl(subcategory3.getSmallImageUrl());
		}
		else if(category instanceof Subcategory4)
		{
			Subcategory4 subcategory4 = (Subcategory4) category;
			responseCategory.setId(subcategory4.getId());
			responseCategory.setName(subcategory4.getName());
			responseCategory.setRelevance(subcategory4.getRelevance());
		}
		list.add(responseCategory);
	}


}
