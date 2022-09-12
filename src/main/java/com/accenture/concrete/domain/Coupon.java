package com.accenture.concrete.domain;

import java.time.LocalDate;

import com.accenture.concrete.response.CouponResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Coupon {
	
	private String id;
	private String description;
	private String seller;
	private String image;
	private LocalDate expiresAt;
	
	public Coupon(CouponResponse response) {
		this.id = response.getId();
		this.description = response.getDescription();
		this.seller = response.getSeller();
		this.image = response.getImage();
		this.expiresAt = response.getExpiresAt();
	}
	
	@JsonIgnore
	public boolean isExpired() {
		return LocalDate.now().isAfter(expiresAt);
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

	@JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate getExpiresAt() {
		return expiresAt;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", description=" + description + ", seller=" + seller + ", image=" + image
				+ ", expiresAt=" + expiresAt + "]";
	}
	
}
