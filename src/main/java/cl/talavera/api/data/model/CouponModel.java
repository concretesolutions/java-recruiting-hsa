package cl.talavera.api.data.model;

import cl.talavera.api.core.domain.Coupon;
import lombok.Data;

import java.text.DateFormat;
import java.util.Date;

@Data
public class CouponModel {
    private String id;
    private Date expiresAt;
    private String seller;
    private String description;
    private String image;

    public static Coupon CouponFrom(CouponModel c, DateFormat f) {
        return Coupon.builder()
                .id(c.getId())
                .expires(f.format(c.getExpiresAt()))
                .seller(c.getSeller())
                .image(c.getImage())
                .description(c.getDescription())
                .build();
    }
}
