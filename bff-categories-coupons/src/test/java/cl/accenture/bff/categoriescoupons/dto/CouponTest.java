package cl.accenture.bff.categoriescoupons.dto;

import org.junit.jupiter.api.Test;

import static java.time.LocalDate.EPOCH;
import static org.assertj.core.api.Assertions.assertThat;

/*
 * Copyright (c) 2023 Boris Molina
 */
public class CouponTest {

    @Test
    public void testCoupon() {
        Coupon subCoupon = new Coupon();
        Coupon coupon = Coupon.builder()
                .id("123")
                .description("20%")
                .seller("seller")
                .image("image_url")
                .expiresAt(EPOCH)
                .build();

        assertThat(coupon.getId()).isEqualTo("123");
        assertThat(coupon.getDescription()).isEqualTo("20%");
        assertThat(coupon.getSeller()).isEqualTo("seller");
        assertThat(coupon.getImage()).isEqualTo("image_url");
        assertThat(coupon.getExpiresAt()).isEqualTo(EPOCH);

        Coupon anotherCoupon = Coupon.builder()
                .id("123")
                .description("20%")
                .seller("seller")
                .image("image_url")
                .expiresAt(EPOCH)
                .build();

        assertThat(coupon).isEqualTo(anotherCoupon);
        assertThat(coupon.hashCode()).isEqualTo(anotherCoupon.hashCode());
        assertThat(coupon.toString()).isNotNull();
        assertThat(subCoupon).isNotNull();
    }

}
