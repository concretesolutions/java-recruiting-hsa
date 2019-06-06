package com.concrete.challenge.models;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Subcategory_Test {
    
    @Test
	public void subcategory__getId_setId() {
    	Subcategory_ sc = new Subcategory_();
		sc.setId("video-games");
		assertEquals(sc.getId(), "video-games");
	}
    
    @Test
	public void subcategory__getName_setName() {
    	Subcategory_ sc = new Subcategory_();
		sc.setName("Video Games");
		assertEquals(sc.getName(), "Video Games");
	}
    
    @Test
	public void subcategory__getSubcategories_setSubcategories() {
    	Subcategory_ sc = new Subcategory_();
    	ArrayList<Subcategory__> subcategories = null;
		sc.setSubcategories(subcategories);
		assertEquals(sc.getSubcategories(), (ArrayList<Subcategory__>)null);
	}
    
    @Test
	public void subcategory__getIconImageUrl_setIconImageUrl() {
    	Subcategory_ sc = new Subcategory_();
		sc.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		assertEquals(sc.getIconImageUrl(), "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
	}
    
    @Test
	public void subcategory__getRelevance_setRelevance() {
    	Subcategory_ sc = new Subcategory_();
		sc.setRelevance(150);
		assertEquals(sc.getRelevance(), (Integer)150);
	}

}
