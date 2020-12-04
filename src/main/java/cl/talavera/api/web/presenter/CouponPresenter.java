package cl.talavera.api.web.presenter;

import cl.talavera.api.core.domain.Coupon;
import cl.talavera.api.core.port.coupon.CouponsPresenterPort;
import cl.talavera.api.web.view.CouponView;

import java.util.List;
import java.util.stream.Collectors;

public class CouponPresenter implements CouponsPresenterPort {


    private List<CouponView> view;

    @Override
    public void present(List<Coupon> coupons) {
        view = from(coupons);
    }

    private List<CouponView> from(List<Coupon> coupons) {
        return coupons.stream()
                .map(c -> CouponView.from(c))
                .collect(Collectors.toList());
    }

    @Override
    public List<CouponView> retrieve() {
        return view;
    }
}
