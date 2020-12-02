package com.accenture.pruebamanuel.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * Clase que representa el objeto de Categoria.
 * 
 * @author Manuel Jimenez.
 */
@Data
@JsonPropertyOrder({ "id", "name", "relevance", "smallImageUrl", "subcategories" })
@JsonInclude(value = Include.NON_DEFAULT, content = Include.NON_EMPTY)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Categoria implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

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
	private Integer relevance;

	/**
	 * imagen pequena url de la imagen.
	 */
	private String smallImageUrl;

	/**
	 * Subcategortias del modelo categoria.
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Categoria> subcategories;
}
