package com.desafio.accenture.backend.javarecruitinghsa.dto;

import com.desafio.accenture.backend.javarecruitinghsa.constant.Contansts;
import com.desafio.accenture.backend.javarecruitinghsa.dto.response.GenericResponse;
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
public class ProductsSubCategoryDTO {

    @JsonProperty("id")
    String id;

    @JsonProperty("name")
    String name;

    @JsonProperty("relevance")
    @JsonInclude(Include.NON_NULL)
    Integer relevance = 0;

    @JsonProperty("largeImageUrl")
    @JsonInclude(Include.NON_NULL)
    String largeImageUrl;

    @JsonProperty("mediumImageUrl")
    @JsonInclude(Include.NON_NULL)
    String mediumImageUrl;

    @JsonProperty("smallImageUrl")
    @JsonInclude(Include.NON_NULL)
    String smallImageUrl;

    @JsonProperty("iconImageUrl")
    @JsonInclude(Include.NON_NULL)
    String iconImageUrl;

    @JsonProperty("subcategories")
    List<ProductsSubCategoryDTO> subcategories;

}
