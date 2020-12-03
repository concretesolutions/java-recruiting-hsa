package com.desafio.accenture.backend.javarecruitinghsa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SubCategoryDTO {

    @JsonProperty("id")
    String id;

    @JsonProperty("name")
    String name;

    @JsonProperty("subcategories")
    List<ProductsSubCategoryDTO> subcategories;
}
