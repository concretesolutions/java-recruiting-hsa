package com.accenture.javarecruiting.dto;

import lombok.Data;

@Data
public class CouponsDTO {
    private String id;
    private String description;
    private String seller;
    private String image;
    private String expiresAt;
}
