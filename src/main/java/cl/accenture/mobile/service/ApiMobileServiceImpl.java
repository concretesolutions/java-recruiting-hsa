package cl.accenture.mobile.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.accenture.mobile.domain.Categories;
import cl.accenture.mobile.domain.Category;
import cl.accenture.mobile.domain.Coupons;
import cl.accenture.mobile.domain.Subcategory;
import cl.accenture.mobile.domain.SubcategoryLevel2;
import cl.accenture.mobile.domain.SubcategoryLevel3;
import cl.accenture.mobile.domain.SubcategoryLevel4;
import cl.accenture.mobile.exceptions.ApiServerException;
import cl.accenture.mobile.feing.api.client.CategoriesClient;
import cl.accenture.mobile.feing.api.client.CouponsClient;
import cl.accenture.mobile.service.interfaces.ApiMobileSerice;

/**
 * 
 * @author andrea.rojas.ruiz
 *
 */
@Service
public class ApiMobileServiceImpl implements ApiMobileSerice {

	private static final Logger logger = LoggerFactory.getLogger(ApiMobileServiceImpl.class);

	@Autowired
	CategoriesClient categoriesClient;

	@Autowired
	CouponsClient couponsClient;

	/**
	 * Ontiene carrusel con las 5 categorias con mayor relevancia.
	 * 
	 * @return List<Category>
	 */
	@Override
	public List<Category> getCarruselCategories() {
		logger.info("getCarruselCategories - IN");
		List<Category> listTop5Categories = new ArrayList<>();
		Categories categories;
		List<Category> listCategories = new ArrayList<>();
		try {
			categories = categoriesClient.getCategories();
			listCategories = getListCategories(categories);
			List<Category> listSorted = listCategories.stream()
					.sorted(Comparator.comparing(Category::getRelevance).reversed()).collect(Collectors.toList());
			listTop5Categories = listSorted.stream().limit(5).collect(Collectors.toList());
		} catch (Exception e) {
			throw new ApiServerException(e);
		} finally {
			logger.info("getCarruselCategories - OUT");
		}
		return listTop5Categories;
	}

	/**
	 * Se obtienen las categorias y subcategorias
	 * 
	 * @param categories
	 * @return List<Category>
	 */
	private List<Category> getListCategories(Categories categories) {
		List<Category> listCategories = new ArrayList<>();
		int subCategorySize = categories.getSubcategories().size();
		addCategoryToList(listCategories, categories);
		for (int i = 0; i < subCategorySize; i++) {
			Subcategory subcategory = categories.getSubcategories().get(i);
			addCategoryToList(listCategories, subcategory);

			int subcategorySize = subcategory.getSubcategories().size();
			for (int e = 0; e < subcategorySize; e++) {
				SubcategoryLevel2 subcategory2 = subcategory.getSubcategories().get(e);
				addCategoryToList(listCategories, subcategory2);

				int subcategory2Size = subcategory2.getSubcategories().size();
				for (int j = 0; j < subcategory2Size; j++) {
					SubcategoryLevel3 subcategory3 = subcategory2.getSubcategories().get(j);
					addCategoryToList(listCategories, subcategory3);

					int subcategory3Size = subcategory3.getSubcategories().size();
					for (int h = 0; h < subcategory3Size; h++) {
						SubcategoryLevel4 subcategory4 = subcategory3.getSubcategories().get(h);
						addCategoryToList(listCategories, subcategory4);
					}
				}
			}
		}
		return listCategories;
	}

	/**
	 * Se agrega una categoria a la lista general de categorias
	 * 
	 * @param list
	 * @param category
	 */
	private void addCategoryToList(List<Category> list, Object category) {
		Category basicCategory = new Category();
		if (category instanceof Categories) {
			Categories categories = (Categories) category;
			basicCategory.setId(categories.getId());
			basicCategory.setName(categories.getName());

			if (null != categories.getRelevance()) {
				basicCategory.setRelevance(categories.getRelevance());
			}
		} else if (category instanceof Subcategory) {
			Subcategory subcategory = (Subcategory) category;
			basicCategory.setId(subcategory.getId());
			basicCategory.setName(subcategory.getName());

			if (null != subcategory.getRelevance()) {
				basicCategory.setRelevance(subcategory.getRelevance());
			}

		} else if (category instanceof SubcategoryLevel2) {
			SubcategoryLevel2 subcategory2 = (SubcategoryLevel2) category;
			basicCategory.setId(subcategory2.getId());
			basicCategory.setName(subcategory2.getName());

			if (null != subcategory2.getRelevance()) {
				basicCategory.setRelevance(subcategory2.getRelevance());
			}

			basicCategory.setIconImageUrl(subcategory2.getIconImageUrl());
		} else if (category instanceof SubcategoryLevel3) {
			SubcategoryLevel3 subcategory3 = (SubcategoryLevel3) category;
			basicCategory.setId(subcategory3.getId());
			basicCategory.setName(subcategory3.getName());

			if (null != subcategory3.getRelevance()) {
				basicCategory.setRelevance(subcategory3.getRelevance());
			}

			basicCategory.setSmallImageUrl(subcategory3.getSmallImageUrl());
		} else if (category instanceof SubcategoryLevel4) {
			SubcategoryLevel4 subcategory4 = (SubcategoryLevel4) category;
			basicCategory.setId(subcategory4.getId());
			basicCategory.setName(subcategory4.getName());

			if (null != subcategory4.getRelevance()) {
				basicCategory.setRelevance(subcategory4.getRelevance());
			}
		}
		list.add(basicCategory);
	}

	@Override
	public List<Coupons> getCouponsNotExpired() {
		logger.info("getCouponsNotExpired - IN");
		List<Coupons> validCoupons = new ArrayList<>();
		List<Coupons> allCoupons = new ArrayList<>();
		try {
			allCoupons = couponsClient.getCoupons();
			validCoupons = allCoupons.stream().filter(coupon -> coupon.isNotExpired()).collect(Collectors.toList());
		} catch (Exception e) {
			throw new ApiServerException(e);
		} finally {
			logger.info("getCouponsNotExpired - OUT");
		}
		return validCoupons;
	}

	@Override
	public List<Category> getRemainingCategories() {
		logger.info("getRemainingCategories - IN");
		List<Category> listRemainingCategories = new ArrayList<>();
		Categories categories;
		List<Category> listCategories = new ArrayList<>();
		try {
			categories = categoriesClient.getCategories();
			listCategories = getListCategories(categories);
			List<Category> listSorted = listCategories.stream()
					.sorted(Comparator.comparing(Category::getRelevance).reversed()).collect(Collectors.toList());
			listRemainingCategories = listSorted.stream().skip(5).collect(Collectors.toList());
		} catch (Exception e) {
			throw new ApiServerException(e);
		} finally {
			logger.info("getRemainingCategories - OUT");
		}
		return listRemainingCategories;
	}

}
