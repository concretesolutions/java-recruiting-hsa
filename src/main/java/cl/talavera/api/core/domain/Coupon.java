package cl.talavera.api.core.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Coupon {
    private String id;
    private String expires;
    private String seller;
    private String image;
    private String description;
}
