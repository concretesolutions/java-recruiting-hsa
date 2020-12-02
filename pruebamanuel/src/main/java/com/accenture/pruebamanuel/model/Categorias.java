package com.accenture.pruebamanuel.model;

import java.util.List;

import lombok.Data;

/**
 * Clase que representa las categorias top5 y categorias restantes, este TO se
 * utiliza para encapsular la respuesta y entregarla a los que realizen la
 * peticion.
 * 
 * @author Manuel Jimenez.
 */
@Data
public class Categorias {

	/**
	 * TOP5 categoria.
	 */
	List<Categoria> top5Categoria;

	/**
	 * Categorias restantes.
	 */
	List<Categoria> categorias;
}
