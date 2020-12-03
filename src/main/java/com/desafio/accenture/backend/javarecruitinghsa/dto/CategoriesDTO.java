package com.desafio.accenture.backend.javarecruitinghsa.dto;

import com.desafio.accenture.backend.javarecruitinghsa.constant.Contansts;
import com.desafio.accenture.backend.javarecruitinghsa.dto.response.GenericResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CategoriesDTO  {

    @JsonProperty("id")
    String id;

    @JsonProperty("name")
    String name;

    @JsonProperty("subcategories")
    List<SubCategoryDTO> subcategories;
}
