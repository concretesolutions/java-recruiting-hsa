package com.desafio.sha.domain;

public class Coupons {
	private String id;
	private String description;
	private String seller;
	private String image;
	private String expiresAt;

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

	@Override
	public String toString() {
		return "Coupons [id=" + id + ", description=" + description + ", seller=" + seller + ", image=" + image
				+ ", expiresAt=" + expiresAt + "]";
	}

}
