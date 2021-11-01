package com.proyecto.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

// Click derecho sobre esta clase -> run as -> junit test
// Basado en:  https://www.javainuse.com/spring/springboot_testcases

public class TestValidarJson extends PruebasUnitarias 
{
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void validarJsonEmpleado() throws Exception 
	{
		mockMvc.perform(get("/pruebaUnitariaValidarJson")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.nombre").value("Gonzalo"))
				.andExpect(jsonPath("$.sueldo").value(5000000));
		
		// .andExpect(jsonPath("$.sueldo").value(600000));  // Esto provocara que el test falle, ya que espera 5000000, no 600000
		// java.lang.AssertionError: JSON path "$.sueldo" expected:<5000000> but was:<600000>

	}

}

