package cl.concretesolutions.mobileapp.api.coupon;

import java.time.LocalDate;

public class CouponDto {
	private String id;
	private String description;
	private String seller;
	private String image;
	private LocalDate expiresAt;
	
	/**
	 * Constructor
	 */
	public CouponDto() {
		
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the seller
	 */
	public String getSeller() {
		return seller;
	}
	
	/**
	 * @param seller the seller to set
	 */
	public void setSeller(String seller) {
		this.seller = seller;
	}
	
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	/**
	 * @return the expiresAt
	 */
	public LocalDate getExpiresAt() {
		return expiresAt;
	}

	/**
	 * @param expiresAt set the date to expires
	 */
	public void setExpiresAt(String expiresAt) {
		this.expiresAt = expiresAt != null ? LocalDate.parse(expiresAt) : LocalDate.parse("");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CouponDto [id=");
		builder.append(id);
		builder.append(", description=");
		builder.append(description);
		builder.append(", seller=");
		builder.append(seller);
		builder.append(", image=");
		builder.append(image);
		builder.append(", expiresAt=");
		builder.append(expiresAt);
		builder.append("]");
		return builder.toString();
	}
}
