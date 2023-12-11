package cl.accenture.bff.categoriescoupons.service;

import cl.accenture.bff.categoriescoupons.client.CouponsClient;
import cl.accenture.bff.categoriescoupons.dto.Coupon;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Copyright (c) 2023 Boris Molina
 */
@Service
public class CouponsService {

    private final CouponsClient couponsClient;

    public CouponsService(CouponsClient couponsClient) {
        this.couponsClient = couponsClient;
    }

    @Retryable(maxAttemptsExpression = "${retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "${retry.maxDelay}"))
    public List<Coupon> getAllCoupons() {
        return couponsClient.getCoupons();
    }

    @Retryable(maxAttemptsExpression = "${retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "${retry.maxDelay}"))
    public List<Coupon> getValidCoupons() {
        return couponsClient.getCoupons().stream()
                .filter(coupon -> isValidCoupon(coupon.getExpiresAt()))
                .collect(Collectors.toList());
    }

    private boolean isValidCoupon(LocalDate expiresAt) {
        return !expiresAt.isBefore(LocalDate.now());
    }

}
