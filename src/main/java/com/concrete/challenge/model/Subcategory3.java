package com.concrete.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subcategory3 {
    public String id;
    public String name;
    public Integer relevance ;
    @JsonIgnore
    public String largeImageUrl;
    @JsonIgnore
    public String mediumImageUrl;
    public String smallImageUrl;
    private Subcategory4 subcategories[];
}
