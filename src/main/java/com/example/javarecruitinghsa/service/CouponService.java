package com.example.javarecruitinghsa.service;

import com.example.javarecruitinghsa.pojo.Coupon;

import java.util.List;
import java.util.Optional;

public interface CouponService {
    Optional<List<Coupon>> aviable();
}
