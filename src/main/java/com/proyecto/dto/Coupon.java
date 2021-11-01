package com.proyecto.dto;

import java.util.Date;

public class Coupon 
{
	private String id;
	private String description;
	private String seller;
	private String image;
	private Date expiresAt;
	
	public Coupon() {

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

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", description=" + description + ", seller=" + seller + ", image=" + image
				+ ", expiresAt=" + expiresAt + "]";
	}

}
