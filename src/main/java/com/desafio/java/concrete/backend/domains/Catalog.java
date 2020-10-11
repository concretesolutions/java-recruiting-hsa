package com.desafio.java.concrete.backend.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Catalog {

    String id;
    String name;
    int relevance;
    String iconImageUrl;
    String mediumImageUrl;
    String smallImageUrl;
    List<Catalog> subcategories;
}
