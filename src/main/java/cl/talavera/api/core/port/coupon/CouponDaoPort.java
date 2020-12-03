package cl.talavera.api.core.port.coupon;

import cl.talavera.api.core.domain.Coupon;

import java.util.List;

public interface CouponDaoPort {
    List<Coupon> getNonExpired();
}
