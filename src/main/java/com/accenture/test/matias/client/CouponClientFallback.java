package com.accenture.test.matias.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.accenture.test.matias.exception.ServiceUnavailableException;
import com.accenture.test.matias.model.Coupon;
import com.accenture.test.matias.util.Constants;

/**
 * Fallback class for the methods of the Coupons Client.
 * 
 * @author Matias Gomez Arancibia.
 *
 */
@Component
public class CouponClientFallback implements CouponClient {

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<Coupon>> getCoupons() {

        throw new ServiceUnavailableException(Constants.API_COUPON_ERROR, Constants.GENERIC_SOLUTION,
                Constants.SERVICE_CODE_COUPON);
    }

}
