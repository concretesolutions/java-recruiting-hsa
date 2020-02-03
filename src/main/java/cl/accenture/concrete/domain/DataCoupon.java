package cl.accenture.concrete.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Datos que posee el cupon, el cual pertenece a la Coupons API
 * @author c.leon.palacios
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataCoupon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2805286903544855199L;
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("description")
	private String description;
	@JsonProperty("seller")
	private String seller;
	@JsonProperty("image")
	private String image;
	@JsonProperty("expiresAt")
	private String expiresAt;
	
	public String getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public String getSeller() {
		return seller;
	}
	public String getImage() {
		return image;
	}
	public String getExpiresAt() {
		return expiresAt;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setExpiresAt(String expiresAt) {
		this.expiresAt = expiresAt;
	}
}
