package cl.talavera.api.data;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.domain.Coupon;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CouponRestRepository {

    private RestTemplate rest;
    private List<Coupon> coupons;
    String url = "https://cs-hsa-api-coupons.herokuapp.com/coupons";

    public CouponRestRepository() {
        rest = new RestTemplateBuilder().build();
    }

    public List<CouponResponse> get() {
        return Arrays.asList(rest.getForEntity(url, CouponResponse[].class).getBody());
    }
}
