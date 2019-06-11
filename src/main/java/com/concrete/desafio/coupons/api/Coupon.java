package com.concrete.desafio.coupons.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coupon implements Serializable {

  private String id;
  private String description;
  private String seller;
  private String image;
  private String expiresAt;

  public Coupon() {}

  public Coupon(
      final String id,
      final String description,
      final String seller,
      final String image,
      final String expiresAt) {
    this.id = id;
    this.description = description;
    this.seller = seller;
    this.image = image;
    this.expiresAt = expiresAt;
  }

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public String getSeller() {
    return seller;
  }

  public String getImage() {
    return image;
  }

  public String getExpiresAt() {
    return expiresAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Coupon coupon = (Coupon) o;
    return Objects.equals(getId(), coupon.getId())
        && Objects.equals(getDescription(), coupon.getDescription())
        && Objects.equals(getSeller(), coupon.getSeller())
        && Objects.equals(getImage(), coupon.getImage())
        && Objects.equals(getExpiresAt(), coupon.getExpiresAt());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getDescription(), getSeller(), getImage(), getExpiresAt());
  }
}
