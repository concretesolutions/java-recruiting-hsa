package com.accenture.challenge.mapper;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coupon {

    private @Id @GeneratedValue String id;
    private String description;
    private String seller;
    private String image;
    private String expiresAt;

    public String getExpiresAt() {
        return expiresAt;
    }

}
