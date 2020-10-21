package com.desafio_concrete.api.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "description",
    "seller",
    "image",
    "expiresAt"
})

public class Coupon {
	@JsonProperty("id")
    private String id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("seller")
    private String seller;
    @JsonProperty("image")
    private String image;
    @JsonProperty("expiresAt")
    private LocalDate expiresAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("seller")
    public String getSeller() {
        return seller;
    }

    @JsonProperty("seller")
    public void setSeller(String seller) {
        this.seller = seller;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("expiresAt")
    public LocalDate getExpiresAt() {
        return expiresAt;
    }

    @JsonProperty("expiresAt")
    public void setAddress(LocalDate expiresAt) {
        this.expiresAt = expiresAt;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
