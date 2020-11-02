package com.concrete.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subcategory4 {
    public String id;
    public String name;
    public Integer relevance;
}
