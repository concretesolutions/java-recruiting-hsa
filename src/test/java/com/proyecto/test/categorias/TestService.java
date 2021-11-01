package com.proyecto.test.categorias;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.dto.Category;
import com.proyecto.service.ICategoriaService;
import com.proyecto.test.PruebasUnitarias;


public class TestService extends PruebasUnitarias {
	
	@Autowired
	private ICategoriaService servicio;

	@Test
	public void testInsertar() {
		Category categoria = servicio.obtener();

		assertNotNull(categoria);
		assertNotNull(categoria.getId());
		assertNotNull("LEGACY_NAVIGATION", categoria.getName());
	}
}
