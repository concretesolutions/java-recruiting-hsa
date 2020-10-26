package cl.mobile.bff.service.interfaces;

import java.util.List;

import cl.mobile.bff.domain.CouponClientResponse;

public interface CouponService {
	public List<CouponClientResponse> getCouponNotExpiderd();
}
