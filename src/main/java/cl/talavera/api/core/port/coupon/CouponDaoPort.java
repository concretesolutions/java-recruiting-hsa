package cl.talavera.api.core.port.coupon;

import cl.talavera.api.core.domain.Coupon;

import java.text.ParseException;
import java.util.List;

public interface CouponDaoPort {
    List<Coupon> getNonExpired() throws ParseException;
}
