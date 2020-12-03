package cl.talavera.api.data;

import lombok.Data;

import java.util.Date;

@Data
public class CouponResponse {
    private String id;
    private Date expiresAt;
}
