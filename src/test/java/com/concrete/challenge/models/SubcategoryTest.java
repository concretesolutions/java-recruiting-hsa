package com.concrete.challenge.models;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubcategoryTest {
    
    @Test
	public void subcategory_getId_setId() {
    	Subcategory sc = new Subcategory();
		sc.setId("MOB");
		assertEquals(sc.getId(), "MOB");
	}
    
    @Test
	public void subcategory_getName_setName() {
    	Subcategory sc = new Subcategory();
		sc.setName("MOBILE_MARKET");
		assertEquals(sc.getName(), "MOBILE_MARKET");
	}
    
    @Test
	public void subcategory_getSubcategories_setSubcategories() {
    	Subcategory sc = new Subcategory();
    	ArrayList<Subcategory_> subcategories = null;
		sc.setSubcategories(subcategories);
		assertEquals(sc.getSubcategories(), (ArrayList<Subcategory_>)null);
	}

}
