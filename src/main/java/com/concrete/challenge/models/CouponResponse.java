package com.concrete.challenge.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Detalle de modelo de cupones. ")
public class CouponResponse {

	@ApiModelProperty(notes = "Identificador �nico del modelo de cupones")
    private String id;
	@ApiModelProperty(notes = "Descripci�n del cup�n")
    private String description;
	@ApiModelProperty(notes = "Nombre del vendedor")
    private String seller;
	@ApiModelProperty(notes = "Im�gen del cup�n")
    private String image;
	@ApiModelProperty(notes = "Fecha en la que expira el cup�n")
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
