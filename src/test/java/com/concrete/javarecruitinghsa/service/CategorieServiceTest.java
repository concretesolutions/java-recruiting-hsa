package com.concrete.javarecruitinghsa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import com.concrete.javarecruitinghsa.dto.categorie.Categorie;
import com.concrete.javarecruitinghsa.dto.mapper.CategorieMapper;

@SpringBootTest(classes = {CategorieMapper.class})
public class CategorieServiceTest {

	@InjectMocks
	@Spy
	private CategorieService categorieService;

	List<Categorie> categories = new ArrayList<>();
	List<Categorie> categoriesTwo = new ArrayList<>();
	List<Categorie> categoriesThree = new ArrayList<>();
	List<Categorie> categoriesFour = new ArrayList<>();
	
	@BeforeEach
	public void init(){		
		categoriesFour.add(Categorie.builder().id("lvl4").build());
		categoriesFour.add(Categorie.builder().id("lvl4.1").build());
		categoriesFour.add(Categorie.builder().id("lvl4.2").build());
		categoriesFour.add(Categorie.builder().id("lvl4.3").build());
		categoriesFour.add(Categorie.builder().id("lvl4.4").build());
		categoriesFour.add(Categorie.builder().id("lvl4.5").build());
		
		categoriesThree.add(Categorie.builder().id("lvl3").build() );
		
		categoriesTwo.add(Categorie.builder().id("lvl2").build() );
		
		categories.addAll(categoriesFour);
		categories.addAll(categoriesThree);
		categories.addAll(categoriesTwo);
	}
	
	@Test
    public void getCarrouselTest() throws Exception {
		doReturn(categories).when(categorieService).getCategoriesOrderedByRelevance();		
		assertEquals(5, categorieService.getCarrousel().size());		
    }
	
	@Test
    public void getGridTest() throws Exception {		
		doReturn(categories).when(categorieService).getCategoriesOrderedByRelevance();	
		assertEquals(3, categorieService.getGrid().size());
    }
	
}
