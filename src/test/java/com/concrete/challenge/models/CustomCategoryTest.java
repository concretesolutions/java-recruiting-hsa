package com.concrete.challenge.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomCategoryTest {
	
    @Test
	public void categoryResponse_getIconImageUrl_setIconImageUrl() {
    	CustomCategory cc = new CustomCategory();
		cc.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		assertEquals(cc.getIconImageUrl(), "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
	}
    
    @Test
	public void categoryResponse_getSmallImageUrl_setSmallImageUrl() {
    	CustomCategory cc = new CustomCategory();
		cc.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		assertEquals(cc.getSmallImageUrl(), "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
	}
    
    @Test
	public void categoryResponse_getName_setName() {
    	CustomCategory cc = new CustomCategory();
		cc.setName("Video Games");
		assertEquals(cc.getName(), "Video Games");
	}
    
    @Test
	public void categoryResponse_getRelevance_setRelevance() {
    	CustomCategory cc = new CustomCategory();
		cc.setRelevance(150);
		assertEquals(cc.getRelevance(), (Integer)150);
	}
}
