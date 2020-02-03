package cl.accenture.concrete.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.accenture.concrete.domain.BasicCategory;
import cl.accenture.concrete.domain.Categories;
import cl.accenture.concrete.domain.DataCoupon;
import cl.accenture.concrete.domain.Subcategory;
import cl.accenture.concrete.domain.Subcategory2;
import cl.accenture.concrete.domain.Subcategory3;
import cl.accenture.concrete.domain.Subcategory4;
import cl.accenture.concrete.exceptions.ApiServerException;
import cl.accenture.concrete.feing.api.client.CategoriesClient;
import cl.accenture.concrete.feing.api.client.CouponsClient;
import cl.accenture.concrete.service.interfaces.JavaConcreteApiService;

/**
 * 
 * @author c.leon.palacios
 *
 */
@Service
public class JavaConcreteApiServiceImpl implements JavaConcreteApiService{
	
	private static final Logger logger = LoggerFactory.getLogger(JavaConcreteApiServiceImpl.class);
	
	@Autowired
	CategoriesClient categoriesClient;
	
	@Autowired
	CouponsClient couponsClient;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public List<BasicCategory> getTopFiveCategories() {
		logger.info("getTopFiveCategories - IN");
		List<BasicCategory> listTop5Categories = new ArrayList<>();
		try
		{
			Categories categories = categoriesClient.getAllCategories();
			List<BasicCategory> listCategories = getListCategories(categories);
			//Ordena la lista de categorias segun su relevancia
			Collections.sort(listCategories, Collections.reverseOrder());
			for(int i=0;i<5;i++)
			{
				listTop5Categories.add(listCategories.get(i));
			}
			
		}catch (Exception e) {
			throw new ApiServerException(e);
		}finally {
			logger.info("getTopFiveCategories - OUT");
		}
		return listTop5Categories;
	}
	
	/**
	 * Se obtienen las categorias y subcategorias
	 * @param categories
	 * @return
	 */
	private List<BasicCategory> getListCategories(Categories categories)
	{
		List<BasicCategory> listCategories = new ArrayList<>();
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
	
	/**
	 * Se agrega una categoria a la lista general de categorias
	 * @param list
	 * @param category
	 */
	private void addCategoryToList(List<BasicCategory> list, Object category)
	{
		BasicCategory basicCategory = new BasicCategory();
		if(category instanceof Categories)
		{
			Categories categories = (Categories) category;
			basicCategory.setId(categories.getId());
			basicCategory.setName(categories.getName());
			basicCategory.setRelevance(categories.getRelevance());
		}
		else if(category instanceof Subcategory)
		{
			Subcategory subcategory = (Subcategory) category;
			basicCategory.setId(subcategory.getId());
			basicCategory.setName(subcategory.getName());
			basicCategory.setRelevance(subcategory.getRelevance());
		}
		else if(category instanceof Subcategory2)
		{
			Subcategory2 subcategory2 = (Subcategory2) category;
			basicCategory.setId(subcategory2.getId());
			basicCategory.setName(subcategory2.getName());
			basicCategory.setRelevance(subcategory2.getRelevance());
			basicCategory.setIconImageUrl(subcategory2.getIconImageUrl());
		}
		else if(category instanceof Subcategory3)
		{
			Subcategory3 subcategory3 = (Subcategory3) category;
			basicCategory.setId(subcategory3.getId());
			basicCategory.setName(subcategory3.getName());
			basicCategory.setRelevance(subcategory3.getRelevance());
			basicCategory.setSmallImageUrl(subcategory3.getSmallImageUrl());
		}
		else if(category instanceof Subcategory4)
		{
			Subcategory4 subcategory4 = (Subcategory4) category;
			basicCategory.setId(subcategory4.getId());
			basicCategory.setName(subcategory4.getName());
			basicCategory.setRelevance(subcategory4.getRelevance());
		}
		list.add(basicCategory);
	}

	@Override
	public List<DataCoupon> getValidsCoupons() {
		logger.info("getValidsCoupons - IN");
		List<DataCoupon> validCoupons = new ArrayList<>();
		try
		{
			DataCoupon coupon;
			Calendar cal = new GregorianCalendar();
			Date expiresAt;
			List<DataCoupon> allCoupons = couponsClient.getAllCoupons();
			int size = allCoupons.size();
			for(int i=0;i<size;i++)
			{
				coupon = allCoupons.get(i);
				expiresAt = sdf.parse(coupon.getExpiresAt());
				if(expiresAt.compareTo(cal.getTime()) >= 0)
				{
					validCoupons.add(coupon);
				}
			}
		}catch (Exception e) {
			throw new ApiServerException(e);
		}finally {
			logger.info("getValidsCoupons - OUT");
		}
		return validCoupons;
	}

	@Override
	public List<BasicCategory> getRemainingCategories() {
		logger.info("getRemainingCategories - IN");
		List<BasicCategory> listRemainingCategories = new ArrayList<>();
		try
		{
			Categories categories = categoriesClient.getAllCategories();
			List<BasicCategory> listCategories = getListCategories(categories);
			//Ordena la lista de categorias segun su relevancia
			Collections.sort(listCategories, Collections.reverseOrder());
			int listCategoriesSize = listCategories.size();
			for(int i=5;i<listCategoriesSize;i++)
			{
				listRemainingCategories.add(listCategories.get(i));
			}
			
		}catch (Exception e) {
			throw new ApiServerException(e);
		}finally {
			logger.info("getRemainingCategories - OUT");
		}
		return listRemainingCategories;
	}
}
