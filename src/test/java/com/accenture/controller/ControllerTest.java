package com.accenture.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.accenture.dto.CategoryDTO;
import com.accenture.dto.CouponDTO;
import com.accenture.service.CategoryService;
import com.accenture.service.CouponService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Mock
	CategoryService catService;
	
	@Mock
	CouponService cupService;
	
	private List<CategoryDTO> fullTopFive = new ArrayList<>();
	private List<CategoryDTO> fullRest = new ArrayList<>();
	List<CouponDTO> cList = new ArrayList<>();

	@org.junit.Before
	public void init() {
	    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MockitoAnnotations.initMocks(this);
		
		CategoryDTO uno = new CategoryDTO();
		uno.setId("sports");
		uno.setName("Sports");
		uno.setRelevance(1);
		uno.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		CategoryDTO dos = new CategoryDTO();
		dos.setId("books");
		dos.setName("Books");
		dos.setRelevance(2);
		
		CategoryDTO tres = new CategoryDTO();
		tres.setId("outdoor");
		tres.setName("Outdoor");
		tres.setRelevance(3);
		
		CategoryDTO cuatro = new CategoryDTO();
		cuatro.setId("food");
		cuatro.setName("Food");
		cuatro.setRelevance(4);
		cuatro.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		CategoryDTO cinco = new CategoryDTO();
		cinco.setId("travel");
		cinco.setName("Travel");
		cinco.setRelevance(5);
		
		
		this.fullTopFive.add(uno);
		this.fullTopFive.add(dos);
		this.fullTopFive.add(tres);
		this.fullTopFive.add(cuatro);
		this.fullTopFive.add(cinco);
		
		
		// resto categorías
		
		CategoryDTO rest = new CategoryDTO();
		rest.setId("MOB");
		rest.setName("MOBILE_MARKET");
		
		CategoryDTO restOne = new CategoryDTO();
		restOne.setId("video-games");
		restOne.setName("Video Games");
		restOne.setRelevance(150);
		restOne.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		CategoryDTO restTwo = new CategoryDTO();
		restTwo.setId("nintendo");
		restTwo.setName("Nintendo");
		restTwo.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		CategoryDTO restThree = new CategoryDTO();
		restThree.setId("switch");
		restThree.setName("Switch");
		restThree.setRelevance(422);
		
		CategoryDTO restFour = new CategoryDTO();
		restFour.setId("bike");
		restFour.setName("Bike");
		restFour.setRelevance(350);
		restFour.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		
		CategoryDTO restFive = new CategoryDTO();
		restFive.setId("electronics");
		restFive.setName("Electronics");
		restFive.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		CategoryDTO restSix = new CategoryDTO();
		restSix.setId("tv");
		restSix.setName("TV");
		restSix.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		CategoryDTO restSeven = new CategoryDTO();
		restSeven.setId("4k");
		restSeven.setName("4K");
		restSeven.setRelevance(700);
		
		CategoryDTO restEight= new CategoryDTO();
		restEight.setId("hamburger");
		restEight.setName("Hamburger");
		restEight.setRelevance(350);
		restEight.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		CategoryDTO restNine= new CategoryDTO();
		restNine.setId("health");
		restNine.setName("Health");
		restNine.setRelevance(6);
		
		CategoryDTO restTen = new CategoryDTO();
		restTen.setId("toys");
		restTen.setName("Toys");
		restTen.setRelevance(99);
		restTen.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		CategoryDTO restEleven = new CategoryDTO();
		restEleven.setId("puzzles");
		restEleven.setName("Puzzles");
		restEleven.setRelevance(100);
		restEleven.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		this.fullRest.add(rest);
		this.fullRest.add(restOne);
		this.fullRest.add(restTwo);
		this.fullRest.add(restThree);
		this.fullRest.add(restFour);
		this.fullRest.add(restFive);
		this.fullRest.add(restSix);
		this.fullRest.add(restSeven);
		this.fullRest.add(restEight);
		this.fullRest.add(restNine);
		this.fullRest.add(restTen);
		this.fullRest.add(restEleven);
		
	}

	@Test
	public void getTopFiveCategoriesTest() throws Exception {

		Mockito.when(catService.getTopFiveCategories()).thenReturn(this.fullTopFive);
		
		ObjectMapper mapper = new ObjectMapper();
    	String rs = mapper.writeValueAsString(this.fullTopFive);
		String uri = "/categories/topFive";
		mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(content().string(equalTo(rs)));
	}
	
	@Test
	public void getRestOfCategoriesTest() throws Exception {

		Mockito.when(catService.getRestOfCategories()).thenReturn(this.fullRest);
		
		ObjectMapper mapper = new ObjectMapper();
    	String rs = mapper.writeValueAsString(this.fullRest);
		String uri = "/categories/rest";
		mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(content().string(equalTo(rs)));
	}
	
}
