package cl.talavera.api.core.port.coupon;

import java.text.ParseException;

public interface NonExpiredCouponsInteractorPort {
    void run() throws ParseException;
}
