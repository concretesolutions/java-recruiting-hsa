package cl.talavera.api.config;

import cl.talavera.api.core.interactor.NonExpiredCouponsInteractor;
import cl.talavera.api.core.port.coupon.CouponDaoPort;
import cl.talavera.api.core.port.coupon.CouponsPresenterPort;
import cl.talavera.api.core.port.coupon.NonExpiredCouponsInteractorPort;
import cl.talavera.api.data.CouponDao;
import cl.talavera.api.data.CouponRestRepository;
import cl.talavera.api.data.Timer;
import cl.talavera.api.web.CouponPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CouponsConfig {
    @Bean
    public NonExpiredCouponsInteractorPort nonExpiredCouponsInteractor() {

        return new NonExpiredCouponsInteractor(couponDao(), couponsPresenter());
    }

    @Bean
    public CouponsPresenterPort couponsPresenter() {
        return new CouponPresenter();
    }

    @Bean
    public CouponDaoPort couponDao() {
        CouponRestRepository repository = new CouponRestRepository();
        Timer timer = new Timer();
        return new CouponDao(repository, timer);
    }

}
