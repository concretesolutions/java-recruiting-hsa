package cl.concrete.desafio.ecommerce.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cl.concrete.desafio.ecommerce.webservice.client.model.Category;
import cl.concrete.desafio.ecommerce.webservice.client.model.CategoryDto;
import cl.concrete.desafio.ecommerce.webservice.client.model.Coupon;
import cl.concrete.desafio.ecommerce.webservice.client.model.CouponDto;

public class ResourceTransformer {

	/**
	 * 
	 * @param categoryDto
	 * @return
	 */
	public static List<Category> transformDtosToCategory(CategoryDto categoryDto) {
		final List<Category> categories = new ArrayList<Category>();
		ResourceTransformer.transformDtosToCategory(categories, categoryDto.getSubcategories(), categoryDto.getId());
		categories.add(ResourceTransformer.transformDtoToCategory(categoryDto, null));
		return categories;
	}
	
	/**
	 * 
	 * @param categoriesDto
	 * @param parentId
	 * @return
	 */
	public static void transformDtosToCategory(final List<Category> categories, final List<CategoryDto> categoriesDto, final String parentId) {
		for(CategoryDto categoryDto:categoriesDto) {
			if(categoryDto.getSubcategories() != null && !categoryDto.getSubcategories().isEmpty()) {
				// Recursive way to transform the service data model structure
				ResourceTransformer.transformDtosToCategory(categories, categoryDto.getSubcategories(), categoryDto.getId());
			} else {
				categories.add(ResourceTransformer.transformDtoToCategory(categoryDto, parentId));
			}
		}
	}
	
	/**
	 * 
	 * @param categoryDto
	 * @param parentId
	 * @return
	 */
	public static Category transformDtoToCategory(final CategoryDto categoryDto, final String parentId) {
		final Category category = new Category();
		category.setId(categoryDto.getId());
		category.setName(categoryDto.getName());
		category.setRelevance(categoryDto.getRelevance() == null ? -1 : Integer.valueOf(categoryDto.getRelevance()));
		category.setIconImage(categoryDto.getIconImageUrl());
		category.setParentCategory(parentId);
		category.getImages().put("large", categoryDto.getLargeImageUrl());
		category.getImages().put("medium", categoryDto.getMediumImageUrl());
		category.getImages().put("small", categoryDto.getSmallImageUrl());
		return category;
	}
	
	/**
	 * 
	 * @param couponDto
	 * @return
	 * @throws ParseException
	 */
	public static Coupon transformDtoToCoupon(final CouponDto couponDto) throws ParseException {
		final Coupon coupon = new Coupon();
		coupon.setId(couponDto.getId());
		coupon.setDescription(couponDto.getDescription());
		coupon.setSeller(couponDto.getSeller());
		coupon.setExpiresAt(new SimpleDateFormat("yyyy-MM-dd").parse(couponDto.getExpiresAt()));
		coupon.setImageUrl(couponDto.getImageUrl());
		return coupon;
	}
	
	/**
	 * 
	 * @param couponsDto
	 * @return
	 * @throws ParseException
	 */
	public static List<Coupon> transformDtosToCoupon(final List<CouponDto> couponsDto) throws ParseException {
		final List<Coupon> coupons = new ArrayList<Coupon>();
		for(CouponDto couponDto:couponsDto) {
			coupons.add(ResourceTransformer.transformDtoToCoupon(couponDto));
		}
		return coupons;
	}
}