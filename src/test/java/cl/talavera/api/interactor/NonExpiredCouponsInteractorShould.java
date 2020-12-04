package cl.talavera.api.interactor;

import cl.talavera.api.core.domain.Coupon;
import cl.talavera.api.core.interactor.NonExpiredCouponsInteractor;
import cl.talavera.api.core.port.coupon.CouponDaoPort;
import cl.talavera.api.core.port.coupon.CouponsPresenterPort;
import cl.talavera.api.core.port.coupon.NonExpiredCouponsInteractorPort;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class NonExpiredCouponsInteractorShould {
    @Test
    void run() throws ParseException {

        CouponsPresenterPort presenter = mock(CouponsPresenterPort.class);
        CouponDaoPort dao = mock(CouponDaoPort.class);
        NonExpiredCouponsInteractorPort interactor = new NonExpiredCouponsInteractor(dao,presenter);

        List<Coupon> coupons = coupons();
        when(dao.getNonExpired()).thenReturn(coupons);

        interactor.run();
        verify(dao,times(1)).getNonExpired();
        verify(presenter,times(1)).present(coupons);

    }

    private List<Coupon> coupons() {
        return asList(Coupon.builder().build());
    }
}
