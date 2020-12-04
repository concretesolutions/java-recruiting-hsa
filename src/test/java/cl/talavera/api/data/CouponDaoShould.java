package cl.talavera.api.data;

import cl.talavera.api.core.domain.Coupon;
import cl.talavera.api.core.port.coupon.CouponDaoPort;
import cl.talavera.api.data.dao.CouponDao;
import cl.talavera.api.data.model.CouponModel;
import cl.talavera.api.data.repository.CouponRestRepository;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CouponDaoShould {

    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    @Test
    void get() throws ParseException {
        CouponRestRepository repository = mock(CouponRestRepository.class);
        Timer timer = new MockTimer();
        CouponDaoPort dao = new CouponDao(repository,timer);

        when(repository.get()).thenReturn(coupons());

        List<Coupon> result = dao.getNonExpired();
        assertThat(result, equalTo(expected()));
    }

    private List<Coupon> expected() {
        return asList(
                Coupon.builder().id("two").expires("02-01-2020").build(),
                Coupon.builder().id("three").expires("03-01-2020").build(),
                Coupon.builder().id("five").expires("03-01-2023").build()
        );
    }

    private List<CouponModel> coupons() throws ParseException {
        return asList(
                coupon("two", "02-01-2020"),
                coupon("three", "03-01-2020"),
                coupon("one", "01-01-2020"),
                coupon("four", "01-01-2019"),
                coupon("five", "03-01-2023")
        );
    }

    private CouponModel coupon(String three, String s) throws ParseException {
        CouponModel couponThree = new CouponModel();
        couponThree.setId(three);
        couponThree.setExpiresAt(FORMAT.parse(s));
        return couponThree;
    }

    private class MockTimer extends Timer {
        @Override
        public Date now() throws ParseException {
            return FORMAT.parse("01-01-2020");
        }
    }
}
