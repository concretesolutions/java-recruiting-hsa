
package cl.recruiting.hsa.proyecto.legacy.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "description",
    "seller",
    "image",
    "expiresAt"
})
public class Coupon implements Serializable
{

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
    @JsonIgnore


    public Coupon() {
    }

    public Coupon(String id, String description, String seller, String image, String expiresAt) {
        super();
        this.id = id;
        this.description = description;
        this.seller = seller;
        this.image = image;
        this.expiresAt = expiresAt;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Coupon withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Coupon withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("seller")
    public String getSeller() {
        return seller;
    }

    @JsonProperty("seller")
    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Coupon withSeller(String seller) {
        this.seller = seller;
        return this;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    public Coupon withImage(String image) {
        this.image = image;
        return this;
    }

    @JsonProperty("expiresAt")
    public String getExpiresAt() {
        return expiresAt;
    }

    @JsonProperty("expiresAt")
    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Coupon withExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

   

}
