package com.accenture.pruebamanuel.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Clase que representa el objeto de Categoria.
 * 
 * @author Manuel Jimenez.
 */
@Data
@JsonIgnoreProperties
public class Categoria {

	/**
	 * ID de la categoria.
	 */
	private String id;

	/**
	 * nombre de la categoria.
	 */
	private String name;

	/**
	 * relevancia de la categoria.
	 */
	@JsonIgnoreProperties(ignoreUnknown = true)
	private Integer relevance;

	/**
	 * imagen grande url la imagen.
	 */
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String largeImageUrl;

	/**
	 * imagen mediana url de la imagen.
	 */
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String mediumImageUrl;

	/**
	 * imagen pequena url de la imagen.
	 */
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String smallImageUrl;

	/**
	 * Subcategortias del modelo categoria.
	 */
	@JsonIgnoreProperties(ignoreUnknown = true)
	private List<Categoria> subcategories;

	/**
	 * Icono de la imagen url de la imagen.
	 */
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String iconImageUrl;
}
