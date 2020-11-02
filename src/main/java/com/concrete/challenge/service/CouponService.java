package com.concrete.challenge.service;

import com.concrete.challenge.dao.CouponDAO;
import com.concrete.challenge.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouponService {

    @Autowired
    CouponDAO couponDAO;

    public List<Coupon> findCouponsNotExpired(){
        List<Coupon> couponsList = couponDAO.getCoupons();
        couponsList = couponsList.stream().filter(Coupon::valid).collect(Collectors.toList());
        return couponsList;
    }
}
