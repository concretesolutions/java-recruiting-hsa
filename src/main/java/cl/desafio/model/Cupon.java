package cl.desafio.model;

import java.io.Serializable;
import java.util.Date;

public class Cupon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String description;
	private String seller;
	private String image;
	private Date expiresAt;
	
	
	
	
	public Cupon() {
		super();
	}
	
	public Cupon(String id, String description, String seller, String image, Date expiresAt) {
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
	public Date getExpiresAt() {
		return expiresAt;
	}
	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}
	
	
}
