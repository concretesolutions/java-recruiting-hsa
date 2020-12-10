package com.accenture.jnavarrete.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CouponsModel {
    @JsonProperty("id")
    public String id;
    @JsonProperty("description")
    public String description;
    @JsonProperty("seller")
    public String seller;
    @JsonProperty("image")
    public String image;
    @JsonProperty("expiresAt")
    public String expiresAt;

    /* Getter and Setter */
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
