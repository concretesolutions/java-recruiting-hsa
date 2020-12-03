package cl.talavera.api.core.port.coupon;

import cl.talavera.api.core.domain.Coupon;
import cl.talavera.api.web.CouponView;

import java.util.List;

public interface CouponsPresenterPort {
    void present(List<Coupon> coupons);

    List<CouponView> retrieve();
}
