package com.accenture.test.matias.service;

import java.util.List;

import com.accenture.test.matias.model.Coupon;

/**
 * Service that manage the coupons.
 * 
 * @author Matias Gomez Arancibia.
 *
 */
public interface CouponService {

    /**
     * Method that gets the coupons.
     * 
     * @return List of coupons.
     */
    List<Coupon> getNotExpiredCoupons();

}
