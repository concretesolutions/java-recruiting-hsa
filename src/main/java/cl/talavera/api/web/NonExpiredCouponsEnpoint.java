package cl.talavera.api.web;

import cl.talavera.api.core.port.coupon.CouponsPresenterPort;
import cl.talavera.api.core.port.coupon.NonExpiredCouponsInteractorPort;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class NonExpiredCouponsEnpoint {
    private final NonExpiredCouponsInteractorPort interactor;
    private final CouponsPresenterPort presenter;


    public NonExpiredCouponsEnpoint(NonExpiredCouponsInteractorPort interactor, CouponsPresenterPort presenter) {
        this.interactor = interactor;
        this.presenter = presenter;
    }

    public ResponseEntity<List<CouponView>> present() {
        interactor.run();
        return ResponseEntity.ok(presenter.retrieve());
    }
}
