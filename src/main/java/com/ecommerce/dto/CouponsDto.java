package com.ecommerce.dto;

import lombok.Data;

@Data
public class CouponsDto {
	private String id;
	private String description;
	private String seller;
	private String image;
	private String expiresAt;
}
