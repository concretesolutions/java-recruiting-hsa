package com.concrete.javarecruitinghsa.restcontroller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.concrete.javarecruitinghsa.dto.categorie.Categorie;
import com.concrete.javarecruitinghsa.service.CategorieService;

@SpringBootTest
@AutoConfigureMockMvc
public class CategorieRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CategorieService categorieService;
	
	
	@Test
	public void getCarrouselNotFound() throws Exception {
		List<Categorie> categorie = new ArrayList<Categorie>();
		
		when(categorieService.getCarrousel()).thenReturn(categorie);
		mockMvc.perform( MockMvcRequestBuilders.get("/v1/categorie/carrousel")).andExpect( status().isNotFound() );	
	}
	
	@Test
	public void getCarrouselOk() throws Exception {
		List<Categorie> categorie = new ArrayList<Categorie>();
		categorie.add(new Categorie());
		
		when(categorieService.getCarrousel()).thenReturn(categorie);
		mockMvc.perform( MockMvcRequestBuilders.get("/v1/categorie/carrousel")).andExpect( status().isOk() );	
	}
	
	@Test
	public void getGridNotFound() throws Exception {
		List<Categorie> categorie = new ArrayList<Categorie>();
		
		when(categorieService.getGrid()).thenReturn(categorie);
		mockMvc.perform( MockMvcRequestBuilders.get("/v1/categorie/grid")).andExpect( status().isNotFound() );	
	}
	
	@Test
	public void getGridOk() throws Exception {
		List<Categorie> categorie = new ArrayList<Categorie>();
		categorie.add(new Categorie());
		
		when(categorieService.getGrid()).thenReturn(categorie);
		mockMvc.perform( MockMvcRequestBuilders.get("/v1/categorie/grid")).andExpect( status().isOk() );	
	}
}
