package com.desafio.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubcategoryLv4 extends BaseCategorie {


    public SubcategoryLv4() {
    }

    public SubcategoryLv4(String id, String name, int relevance) {
        super(id, name, relevance);
    }
}
