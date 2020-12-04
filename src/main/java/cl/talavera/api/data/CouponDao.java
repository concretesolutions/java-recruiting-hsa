package cl.talavera.api.data;

import cl.talavera.api.core.domain.Coupon;
import cl.talavera.api.core.port.coupon.CouponDaoPort;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class CouponDao implements CouponDaoPort {
    private final CouponRestRepository repository;
    public static final DateFormat FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    private final Timer timer;

    public CouponDao(CouponRestRepository repository,Timer timer) {
        this.repository = repository;
        this.timer  =  timer;
    }

    @Override
    public List<Coupon> getNonExpired() throws ParseException {

        return nonExpiredfrom(repository.get());
    }

    private List<Coupon> nonExpiredfrom(List<CouponResponse> couponResponses) throws ParseException {

        return couponResponses.stream()
                .filter(this::nonExpired)
                .map(c -> build(c))
                .collect(Collectors.toList());
    }

    private Coupon build(CouponResponse c) {
        return Coupon.builder()
                .id(c.getId())
                .expires(FORMAT.format(c.getExpiresAt()))
                .build();
    }

    private boolean nonExpired(CouponResponse c) {
        try {
            return c.getExpiresAt().after(timer.now());
        } catch (ParseException e) {
            return false;
        }
    }
}
