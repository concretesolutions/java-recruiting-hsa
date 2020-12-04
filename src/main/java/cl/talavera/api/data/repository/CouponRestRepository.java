package cl.talavera.api.data.repository;

import cl.talavera.api.core.domain.Coupon;
import cl.talavera.api.data.model.CouponModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class CouponRestRepository {

    private RestTemplate rest;
    private List<Coupon> coupons;
    String url = "https://cs-hsa-api-coupons.herokuapp.com/coupons";

    public CouponRestRepository() {
        rest = new RestTemplateBuilder().build();
    }

    public List<CouponModel> get() {
        return Arrays.asList(rest.getForEntity(url, CouponModel[].class).getBody());
    }
}
