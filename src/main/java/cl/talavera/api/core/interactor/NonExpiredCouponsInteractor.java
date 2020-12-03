package cl.talavera.api.core.interactor;

import cl.talavera.api.core.port.coupon.CouponDaoPort;
import cl.talavera.api.core.port.coupon.CouponsPresenterPort;
import cl.talavera.api.core.port.coupon.NonExpiredCouponsInteractorPort;

public class NonExpiredCouponsInteractor implements NonExpiredCouponsInteractorPort {

    private final CouponsPresenterPort presenter;
    private final CouponDaoPort dao;

    public NonExpiredCouponsInteractor(CouponDaoPort dao, CouponsPresenterPort presenter) {
        this.dao = dao;
        this.presenter = presenter;
    }

    @Override
    public void run() {
        presenter.present(dao.getNonExpired());
    }
}
