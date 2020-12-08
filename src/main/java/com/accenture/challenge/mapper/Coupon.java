package com.accenture.challenge.mapper;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coupon {

    private @Id @GeneratedValue String id;
    private String description;
    private String seller;
    private String image;
    private String expiresAt;

    public Coupon(String id){
        super();
        this.id = id;
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

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (!(obj instanceof Coupon)) return false;
      Coupon Coupon = (Coupon) obj;
      return Objects.equals(this.id, Coupon.id) && 
             Objects.equals(this.description, Coupon.description) && 
             Objects.equals(this.seller, Coupon.seller);
    }
    @Override
    public String toString() {
    return "Coupon{" + 
                "id=" + this.id + ", " + 
                "description='" + this.description + ", " + 
                "seller='" + this.seller + 
                "image='" + this.image + 
                "expiresAt='" + this.expiresAt + 
                '}';
  }
    
}
