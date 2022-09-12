package com.accenture.concrete.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CouponResponse {

	private String id;
	private String description;
	private String seller;
	private String image;
	private LocalDate expiresAt;
	
	@JsonCreator(mode = Mode.PROPERTIES)
	public CouponResponse(
			@JsonProperty("id") String id, 
			@JsonProperty("description") String description, 
			@JsonProperty("seller") String seller, 
			@JsonProperty("image") String image, 
			@JsonProperty("expiresAt") LocalDate expiresAt) {
		super();
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

	public LocalDate getExpiresAt() {
		return expiresAt;
	}
	
}
