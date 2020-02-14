package cl.accenture.mobile.service.interfaces;

import java.util.List;

import cl.accenture.mobile.domain.Category;
import cl.accenture.mobile.domain.Coupons;

/**
 * 
 * @author andrea.rojas.ruiz
 *
 */
public interface ApiMobileSerice {
	
	List<Category> getCarruselCategories();
	List<Category> getRemainingCategories();
	List<Coupons> getCouponsNotExpired();
	

}
