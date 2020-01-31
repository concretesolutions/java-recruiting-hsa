package cl.accenture.concrete.service.interfaces;

import java.util.List;

import cl.accenture.concrete.domain.ResponseCategory;
import cl.accenture.concrete.domain.ResponseCoupon;


public interface ConcreteService {

	List<ResponseCategory> getTopFive();
	List<ResponseCategory> getRemaining();
	List<ResponseCoupon> getValidsCoupons();
}
