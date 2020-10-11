package com.desafio.java.concrete.backend.domains;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Builder
public class CatalogTable {

    String id;
    String name;
    int relevance;
    String smallImageUrl;
    List<Catalog> subcategories;
}
