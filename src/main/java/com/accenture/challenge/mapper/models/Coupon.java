package com.accenture.challenge.mapper.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coupon {

    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("seller")
    @Expose
    private Object seller;
    @SerializedName("image")
    @Expose
    private Object image;
    @SerializedName("expiresAt")
    @Expose
    private Object expiresAt;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getSeller() {
        return seller;
    }

    public void setSeller(Object seller) {
        this.seller = seller;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public Object getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Object expiresAt) {
        this.expiresAt = expiresAt;
    }

}