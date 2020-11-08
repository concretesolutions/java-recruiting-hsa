package com.accenture.test.matias.service;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.test.matias.client.CouponClient;
import com.accenture.test.matias.model.Coupon;
import com.accenture.test.matias.util.AccentureUtils;
import com.accenture.test.matias.util.CouponDateStatus;
import com.accenture.test.matias.util.DateUtils;
import com.accenture.test.matias.util.DateTime;

/**
 * Service that manage the coupons.
 * 
 * @author Matias Gomez Arancibia.
 *
 */
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    public DateTime dateTime;
    
    /**
     * DateFormat for the expired date of coupons.
     */
    private String expiredDateFormat = "yyyy-MM-dd";

    /**
     * Coupon clients that makes the api calls.
     */
    @Autowired
    private CouponClient couponClient;
    
    public CouponServiceImpl(final DateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Coupon> getNotExpiredCoupons() {

        List<Coupon> response = couponClient.getCoupons().getBody();
        if (response != null && !response.isEmpty()) {
            response = filterByNotExpired(response);
        }
        return response;
    }

    /**
     * Method that filters the coupons and excludes the expired coupons.
     * 
     * @param coupons Coupons to filter.
     * @return No expired coupons.
     */
    private List<Coupon> filterByNotExpired(List<Coupon> coupons) {

        List<Coupon> response = coupons;
        Date today = DateUtils.truncateDateAtDay(dateTime.getDate());
        Predicate<Coupon> isCouponExpired = c -> {
            CouponDateStatus couponDateStatus = getCouponDateStatus(c, today);
            return couponDateStatus == CouponDateStatus.UNDEFINED_DATE || couponDateStatus == CouponDateStatus.EXPIRED;
        };

        response.removeIf(isCouponExpired);

        return response;
    }

    /**
     * Method that indicates if a coupon is expired or not.
     * 
     * @param coupon Coupon to compare.
     * @param today Today Date.
     * @return status of the coupon.
     */
    private CouponDateStatus getCouponDateStatus(Coupon coupon, Date today) {

        CouponDateStatus status = null;
        String expiresAt = coupon.getExpiresAt();
        if (AccentureUtils.isNullOrEmpty(expiresAt)) {
            return status = CouponDateStatus.UNDEFINED_DATE;
        }

        Date couponDate = DateUtils.getDateWithFormat(expiresAt, expiredDateFormat);
        if (couponDate == null) {
            status = CouponDateStatus.UNDEFINED_DATE;
        } else if (DateUtils.isFirstDateAfterSecond(couponDate, today)) {
            status = CouponDateStatus.EXPIRED;
        } else {
            status = CouponDateStatus.NOT_EXPIRED;
        }
        return status;
    }
}
