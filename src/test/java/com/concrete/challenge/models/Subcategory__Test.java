package com.concrete.challenge.models;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Subcategory__Test {
    
    @Test
	public void subcategory___getId_setId() {
    	Subcategory__ sc = new Subcategory__();
		sc.setId("nintendo");
		assertEquals(sc.getId(), "nintendo");
	}
    
    @Test
	public void subcategory___getName_setName() {
    	Subcategory__ sc = new Subcategory__();
		sc.setName("Nintendo");
		assertEquals(sc.getName(), "Nintendo");
	}
    
    @Test
	public void subcategory___getSubcategories_setSubcategories() {
    	Subcategory__ sc = new Subcategory__();
    	ArrayList<Subcategory___> subcategories = null;
		sc.setSubcategories(subcategories);
		assertEquals(sc.getSubcategories(), (ArrayList<Subcategory___>)null);
	}
    
    @Test
	public void subcategory___getLargeImageUrl_setLargeImageUrl() {
    	Subcategory__ sc = new Subcategory__();
		sc.setLargeImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		assertEquals(sc.getLargeImageUrl(), "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
	}
    
    @Test
	public void subcategory___getMediumImageUrl_setMediumImageUrl() {
    	Subcategory__ sc = new Subcategory__();
		sc.setMediumImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		assertEquals(sc.getMediumImageUrl(), "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
	}
    
    @Test
	public void subcategory___getSmallImageUrl_setSmallImageUrl() {
    	Subcategory__ sc = new Subcategory__();
		sc.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		assertEquals(sc.getSmallImageUrl(), "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
	}
    
    @Test
	public void subcategory___getRelevance_setRelevance() {
    	Subcategory__ sc = new Subcategory__();
		sc.setRelevance(150);
		assertEquals(sc.getRelevance(), (Integer)150);
	}

}
