package ServiceConsumer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coupon {
    private String id;
    private String description;
    private String seller;
    private String image;
    private String expiresAt;

    //Constructor defined for testing purposes
    public Coupon(String id, String expiresAt) {
        this.id = id;
        this.expiresAt = expiresAt;
    }

    public boolean equals(Object object) {
        Coupon emp = (Coupon) object;
            if(this.id.equalsIgnoreCase(emp.getId()) && expiresAt.equalsIgnoreCase(emp.getExpiresAt()))
            return true;
        else
            return false;
    }

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

    @Override
    public String toString() {
        return "Coupon { " +
                "id = '" + id + '\'' +
                ", description = '" + description + '\'' +
                ", seller = '" + seller + '\'' +
                ", image = '" + image + '\'' +
                ", expiresAt = '" + expiresAt + '\'' +
                '}';
    }
}
