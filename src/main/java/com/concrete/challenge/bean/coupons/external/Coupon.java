package com.concrete.challenge.bean.coupons.external;

import com.concrete.challenge.bean.coupons.structure.Description;
import com.concrete.challenge.bean.coupons.structure.ExpiresAt;
import com.concrete.challenge.bean.coupons.structure.Id;
import com.concrete.challenge.bean.coupons.structure.Image;
import com.concrete.challenge.bean.coupons.structure.Seller;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Coupon
        implements Id, Description, Seller, Image, ExpiresAt {

    private String id;
    private String description;
    private String seller;
    private String image;
    private String expiresAt;

    @Builder
    public Coupon(String id, String description, String seller, String image, String expiresAt) {
        this.id = id;
        this.description = description;
        this.seller = seller;
        this.image = image;
        this.expiresAt = expiresAt;
    }
}
