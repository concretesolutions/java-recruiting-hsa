package com.accenture.test.matias.model;

import lombok.Data;

/**
 * Model class for a Coupon.
 * 
 * @author Matias Gomez Arancibia.
 *
 */
@Data
public class Coupon {

    /**
     * ID of the Coupon.
     */
    private String id;

    /**
     * Description of the Coupon.
     */
    private String description;

    /**
     * Name of who's the seller where to use the coupon.
     */
    private String seller;

    /**
     * Image url of the coupon.
     */
    private String image;

    /**
     * Expiration date of the coupon.
     */
    private String expiresAt;

}
