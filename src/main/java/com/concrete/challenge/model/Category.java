package com.concrete.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
    private String id;
    private String name;
    private Integer relevance;
    private Subcategory subcategories[];
}
