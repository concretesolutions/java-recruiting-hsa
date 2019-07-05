package cl.accenture.concrete.challenge.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CouponDTO {

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
	
	public boolean isValid(LocalDate dt, String format) {
		final LocalDate couponDate = LocalDate.parse(this.expiresAt, DateTimeFormatter.ofPattern(format));
		return couponDate.isAfter(dt);
	}
}
