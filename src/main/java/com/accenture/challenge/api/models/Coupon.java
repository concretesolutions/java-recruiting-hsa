package com.accenture.challenge.api.models;

import lombok.Data;

@Data
public class Coupon {

	private String id;
	private String description;
	private String seller;
	private String image;
	private String expiresAt;
	
}
