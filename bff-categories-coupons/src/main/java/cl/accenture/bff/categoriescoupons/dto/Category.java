package cl.accenture.bff.categoriescoupons.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * Copyright (c) 2023 Boris Molina
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    private String id;
    private String name;
    private int relevance;
    private String iconImageUrl;
    @JsonIgnore
    private String largeImageUrl;
    @JsonIgnore
    private String mediumImageUrl;
    private String smallImageUrl;
    private List<Category> subcategories;

}
