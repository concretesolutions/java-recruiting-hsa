package com.accenture.test.matias.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.accenture.test.matias.exception.ServiceUnavailableException;
import com.accenture.test.matias.model.Coupon;
import com.accenture.test.matias.util.Constants;

import lombok.extern.slf4j.Slf4j;

/**
 * Fallback class for the methods of the Coupons Client.
 * 
 * @author Matias Gomez Arancibia.
 *
 */
@Slf4j
@Component
public class CouponClientFallback implements CouponClient {

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<Coupon>> getCoupons() {

        log.error("Fallback: Error al conseguir los cupones desde la API.");
        throw new ServiceUnavailableException(Constants.API_COUPON_ERROR, Constants.GENERIC_SOLUTION,
                Constants.SERVICE_CODE_COUPON);
    }

}
