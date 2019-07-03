package cl.accenture.concrete.challenge.model;

public class Coupon {

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
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("{");
		str.append("id: " + getId());
		str.append("description: " + getDescription());
		str.append("seller: " + getSeller());
		str.append("image: " + getImage());
		str.append("expiresAt: " + getExpiresAt());
		str.append("}");
		return str.toString();
	}

}
