package com.concrete.categoria.dto;

public class CouponDTO {
	
	String id;
	String description;
	String seller;
	String image;
	String expiresAt;
	
	
	
	public CouponDTO(String id, String description, String seller, String image, String expiresAt) {
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
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getExpiresAt() {
		return expiresAt;
	}
	public void setExpiresAt(String expiresAt) {
		this.expiresAt = expiresAt;
	}
	
	

}
