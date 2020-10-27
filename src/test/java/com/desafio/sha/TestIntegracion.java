package com.desafio.sha;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MimeTypeUtils;

import com.desafio.sha.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class TestIntegracion {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getCupones() throws Exception {
		mvc.perform(get("/cupones")).andExpect(status().isOk());
	}

	@Test
	public void getCategoriasRemaining() throws Exception {
		mvc.perform(get("/categorias/remaining").accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}

	@Test
	public void getCategoriasTopFive() throws Exception {
		mvc.perform(get("/categorias/top-five").accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}

}
