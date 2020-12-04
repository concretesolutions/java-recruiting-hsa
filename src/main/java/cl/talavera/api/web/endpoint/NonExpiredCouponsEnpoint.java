package cl.talavera.api.web.endpoint;

import cl.talavera.api.core.port.coupon.CouponsPresenterPort;
import cl.talavera.api.core.port.coupon.NonExpiredCouponsInteractorPort;
import cl.talavera.api.web.view.CouponView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class NonExpiredCouponsEnpoint {
    private final NonExpiredCouponsInteractorPort interactor;
    private final CouponsPresenterPort presenter;


    public NonExpiredCouponsEnpoint(NonExpiredCouponsInteractorPort interactor, CouponsPresenterPort presenter) {
        this.interactor = interactor;
        this.presenter = presenter;
    }

    @RequestMapping("/coupons/non_expired")
    public ResponseEntity<List<CouponView>> present() throws ParseException {
        interactor.run();
        return ResponseEntity.ok(presenter.retrieve());
    }
}
