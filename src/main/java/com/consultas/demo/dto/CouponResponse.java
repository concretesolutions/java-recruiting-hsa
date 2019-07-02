package com.consultas.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Detalle de modelo de categorias. ")
public class CouponResponse {

	@ApiModelProperty(notes = "Identificador único del modelo de cupon")
    private String id;
	@ApiModelProperty(notes = "Description de cupon")
    private String description;
	@ApiModelProperty(notes = "Seller de cupon")
    private String seller;
	@ApiModelProperty(notes = "Image de cupon")
    private String image;
	@ApiModelProperty(notes = "ExpiresAt de cupon")
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
    

}
