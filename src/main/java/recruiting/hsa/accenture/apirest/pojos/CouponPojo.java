package recruiting.hsa.accenture.apirest.pojos;

import org.json.JSONObject;

public class CouponPojo {
    private String id;
    private String description;
    private String seller;
    private String image;
    private String expiresAt;

    public CouponPojo() {
		// TODO Auto-generated constructor stub
	}

	public CouponPojo(JSONObject auxCoupon) {
		// TODO Auto-generated constructor stub
		this.id = auxCoupon.optString("id");
		this.description = auxCoupon.optString("description");
		this.seller = auxCoupon.optString("seller");
		this.image = auxCoupon.optString("image");
		this.expiresAt = auxCoupon.optString("expiresAt");
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

	public String getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(String expiresAt) {
		this.expiresAt = expiresAt;
	}
    
}
