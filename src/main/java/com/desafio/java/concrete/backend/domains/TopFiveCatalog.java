package com.desafio.java.concrete.backend.domains;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter@Setter
@Builder
public class TopFiveCatalog {

    int relevance;
    String iconImageUrl;
    String name;

}
