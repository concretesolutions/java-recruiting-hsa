package com.concrete.challenge.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Subcategory___Test {
    
    @Test
	public void subcategory____getId_setId() {
    	Subcategory___ sc = new Subcategory___();
		sc.setId("switch");
		assertEquals(sc.getId(), "switch");
	}
    
    @Test
	public void subcategory____getName_setName() {
    	Subcategory___ sc = new Subcategory___();
		sc.setName("Switch");
		assertEquals(sc.getName(), "Switch");
	}
    
    @Test
	public void subcategory____getRelevance_setRelevance() {
    	Subcategory___ sc = new Subcategory___();
		sc.setRelevance(422);
		assertEquals(sc.getRelevance(), (Integer)422);
	}

}
