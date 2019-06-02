package com.concrete.challenge.service;

import com.concrete.challenge.bean.coupons.external.Coupon;
import com.concrete.challenge.client.CouponsClient;
import com.concrete.challenge.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouponsService {

    @Autowired
    private CouponsClient couponsClient;

    @Autowired
    private DateUtil dateUtil;

    public List<Coupon> getActiveCoupons() {

        LocalDate today = dateUtil.getToday();

        return couponsClient.getCoupons()
                .stream()
                .filter(coupon ->
                        LocalDate.parse(coupon.getExpiresAt()).isEqual(today) ||
                                LocalDate.parse(coupon.getExpiresAt()).isAfter(today))
                .collect(Collectors.toList());
    }
}
