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
		
		List<CategoryDTO> subTwoL = new ArrayList<>();
		CategoryDTO subTwo = new CategoryDTO();
		subTwo.setId("sports");
		subTwo.setName("Sports");
		subTwo.setRelevance(1);
		subTwo.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		subTwoL.add(subTwo);
		
		CategoryDTO subTwo2 = new CategoryDTO();
		subTwo2.setId("books");
		subTwo2.setName("Books");
		subTwo2.setRelevance(2);
		subTwo2.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		subTwoL.add(subTwo2);
		
		CategoryDTO subTwo3 = new CategoryDTO();
		subTwo3.setId("outdoor");
		subTwo3.setName("Outdoor");
		subTwo3.setRelevance(3);
		subTwo3.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		subTwoL.add(subTwo3);
		
		CategoryDTO subTwo4 = new CategoryDTO();
		subTwo4.setId("food");
		subTwo4.setName("Food");
		subTwo4.setRelevance(4);
		subTwo4.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		List<CategoryDTO> subTwo4List = new ArrayList<>();
		CategoryDTO subTwo4One = new CategoryDTO();
		subTwo4One.setId("hamburger");
		subTwo4One.setName("Hamburger");
		subTwo4One.setRelevance(350);
		subTwo4One.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		subTwo4List.add(subTwo4One);
		subTwo4.setSubcategories(subTwo4List);
		
		CategoryDTO subTwo5 = new CategoryDTO();
		subTwo5.setId("travel");
		subTwo5.setName("Travel");
		subTwo5.setRelevance(5);
		subTwo5.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		List<CategoryDTO> subThreeL = new ArrayList<>();
		CategoryDTO subThree = new CategoryDTO();
		subThree.setId("bike");
		subThree.setName("Bike");
		subThree.setRelevance(350);
		subThree.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		subThreeL.add(subThree);
		
		subTwo.setSubcategories(subThreeL);
		
		this.fullTopFive.add(subTwo);
		this.fullTopFive.add(subTwo2);
		this.fullTopFive.add(subTwo3);
		this.fullTopFive.add(subTwo4);
		this.fullTopFive.add(subTwo5);
		
		// resto categorías
		CategoryDTO restOne = new CategoryDTO();
		restOne.setId("video-games");
		restOne.setName("Video Games");
		restOne.setRelevance(150);
		restOne.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		
		List<CategoryDTO> restOneL = new ArrayList<>();
		CategoryDTO restOneS = new CategoryDTO();
		restOneS.setId("nintendo");
		restOneS.setName("Nintendo");
		restOneS.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		restOneL.add(restOneS);
		
		List<CategoryDTO> restOneLSub = new ArrayList<>();
		CategoryDTO restOneSS = new CategoryDTO();
		restOneSS.setId("switch");
		restOneSS.setName("Switch");
		restOneSS.setRelevance(422);
		restOneLSub.add(restOneSS);
		
		CategoryDTO restTwo = new CategoryDTO();
		restTwo.setId("electronics");
		restTwo.setName("Electronics");
		restTwo.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		
		List<CategoryDTO> restTwoL = new ArrayList<>();
		CategoryDTO restTwoS = new CategoryDTO();
		restTwoS.setId("tv");
		restTwoS.setName("TV");
		restTwoS.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		restTwoL.add(restTwoS);
		
		List<CategoryDTO> restTwoLSub = new ArrayList<>();
		CategoryDTO restTwoSS = new CategoryDTO();
		restTwoSS.setId("4k");
		restTwoSS.setName("4K");
		restTwoSS.setRelevance(700);
		restTwoLSub.add(restTwoSS);
		
		CategoryDTO restThree = new CategoryDTO();
		restThree.setId("health");
		restThree.setName("Health");
		restThree.setRelevance(6);
		restThree.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		
		CategoryDTO restFour = new CategoryDTO();
		restFour.setId("toys");
		restFour.setName("Toys");
		restFour.setRelevance(99);
		restFour.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		
		List<CategoryDTO> restFourL = new ArrayList<>();
		CategoryDTO restFourS = new CategoryDTO();
		restFourS.setId("puzzles");
		restFourS.setName("Puzzles");
		restFourS.setRelevance(100);
		restFourS.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		restFourL.add(restFourS);
		
		
		restFour.setSubcategories(restFourL);
		
		restTwoS.setSubcategories(restTwoLSub);
		restTwo.setSubcategories(restTwoL);
		
		restOneS.setSubcategories(restOneLSub);
		restOne.setSubcategories(restOneL);
		
		this.fullRest.add(restOne);
		this.fullRest.add(restTwo);
		this.fullRest.add(restThree);
		this.fullRest.add(restFour);
		
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
