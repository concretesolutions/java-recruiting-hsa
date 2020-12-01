package cl.recruiting.hsa.proyecto.data.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_coupon")
public class DataCoupon {

	@Id
	@Column(name = "id", nullable = true, length=255)
    private String id;

    
  	@Column(nullable = true, length=500)
    private String description;
  	
  	@Column(nullable = true, length=500)
    private String seller;
  	
  	@Column(nullable = true, length=255)
    private String image;
  	
    private Timestamp expiresAt;

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

	public Timestamp getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Timestamp expiresAt) {
		this.expiresAt = expiresAt;
	}

	public DataCoupon(String id, String description, String seller, String image,
			Timestamp expiresAt) {
		super();
		this.id = id;
		this.description = description;
		this.seller = seller;
		this.image = image;
		this.expiresAt = expiresAt;
	}
	public DataCoupon() {
		super();

	}
    
}
