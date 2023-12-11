package cl.accenture.bff.categoriescoupons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/*
 * Copyright (c) 2023 Boris Molina
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon {

    private String id;
    private String description;
    private String seller;
    private String image;
    private LocalDate expiresAt;

}
