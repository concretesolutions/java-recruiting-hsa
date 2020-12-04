package cl.talavera.api.web.presenter;

import cl.talavera.api.core.domain.Coupon;
import cl.talavera.api.core.port.coupon.CouponsPresenterPort;


import java.util.List;


public class CouponPresenter implements CouponsPresenterPort {


    private List<Coupon> view;

    @Override
    public void present(List<Coupon> coupons) {
        view = coupons;
    }


    @Override
    public List<Coupon> retrieve() {
        return view;
    }
}
