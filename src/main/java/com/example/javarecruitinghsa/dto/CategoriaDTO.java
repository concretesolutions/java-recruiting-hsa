package com.example.javarecruitinghsa.dto;

public class CategoriaDTO {

    private String categoria;
    private String subcategoria;
    private String nombre;
    private Long relevancia;
    private String imageUrl;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getRelevancia() {
        return relevancia;
    }

    public void setRelevancia(Long relevancia) {
        this.relevancia = relevancia;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
