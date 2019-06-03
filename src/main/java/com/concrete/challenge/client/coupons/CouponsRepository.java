package com.concrete.challenge.client.coupons;

import com.concrete.challenge.bean.coupons.external.Coupon;

import java.util.List;

public interface CouponsRepository {

    List<Coupon> getCoupons();
}
