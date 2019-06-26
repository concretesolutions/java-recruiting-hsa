package cl.concrete.desafio.ecommerce.webservice.client.model;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class Coupon {

	@ApiModelProperty(notes = "Coupon ID")
	private String id;
	@ApiModelProperty(notes = "Coupon short description")
	private String description;
	@ApiModelProperty(notes = "Seller of the coupon")
	private String seller;
	@ApiModelProperty(notes = "Url to image")
	private String imageUrl;
	@ApiModelProperty(notes = "Expiration date of coupon")
	private Date expiresAt;
	
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Date getExpiresAt() {
		return expiresAt;
	}
	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}
	
}
