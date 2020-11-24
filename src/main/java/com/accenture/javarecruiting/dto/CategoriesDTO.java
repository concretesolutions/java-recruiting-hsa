package com.accenture.javarecruiting.dto;

import lombok.Data;
import java.util.List;

/*
* TODO: Si el equipo Mobile requiere las URL de las imagenes Large y Medium, solo habilitar atributos comentados.
* */

@Data
public class CategoriesDTO {
    private String id;
    private String name;
    private Integer relevance;
    private String iconImageUrl;
//    private String largeImageUrl;
//    private String mediumImageUrl;
    private String smallImageUrl;
    private List<CategoriesDTO> subcategories;
}
