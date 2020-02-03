package cl.accenture.concrete.service.interfaces;

import java.util.List;

import cl.accenture.concrete.domain.BasicCategory;
import cl.accenture.concrete.domain.DataCoupon;

/**
 * 
 * @author c.leon.palacios
 *
 */
public interface JavaConcreteApiService {

	/**
	 * Retorna las primeras 5 categorias segun su relevancia
	 * @return List<BasicCategory>
	 */ 
	List<BasicCategory> getTopFiveCategories();
	
	/**
	 * Retorna los cupones validos
	 * @return List<DataCoupon>
	 */
	List<DataCoupon> getValidsCoupons();
	
	/**
	 * Retorna las categorias siguientes a las top 5
	 * @return List<BasicCategory>
	 */
	List<BasicCategory> getRemainingCategories();
}
