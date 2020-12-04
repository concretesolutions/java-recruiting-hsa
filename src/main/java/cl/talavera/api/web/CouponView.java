package cl.talavera.api.web;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CouponView {
    private String id;
    private String expires;
}

