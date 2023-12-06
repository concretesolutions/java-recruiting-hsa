package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@JsonPropertyOrder({ "id", "name", "relevance", "subcategories" })
@EqualsAndHashCode(callSuper = true)
@Data
public class ResponseDTO extends CategoryBaseExtends {

    @JsonProperty("subcategories")
    private List<CategoryBase> subcategories;

}
