package cl.talavera.api.web.view;

import cl.talavera.api.core.domain.Coupon;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CouponView {
    private String id;
    private String expires;
    private String seller;
    private String image;
    private String description;

    public static CouponView from(Coupon c) {
        return CouponView.builder()
                .id(c.getId())
                .expires(c.getExpires())
                .seller(c.getSeller())
                .image(c.getImage())
                .description(c.getDescription())
                .build();
    }
}

