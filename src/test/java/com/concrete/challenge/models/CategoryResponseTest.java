package com.concrete.challenge.models;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryResponseTest {

	@Test
	public void categoryResponse_getId_setId() {
		CategoryResponse cr = new CategoryResponse();
		cr.setId("ROOT");
		assertEquals(cr.getId(), "ROOT");
	}
	
	@Test
	public void categoryResponse_getName_setName() {
		CategoryResponse cr = new CategoryResponse();
		cr.setName("LEGACY_NAVIGATION");
		assertEquals(cr.getName(), "LEGACY_NAVIGATION");
	}
	
	@Test
	public void categoryResponse_getSubcategories_setSubcategories() {
		CategoryResponse cr = new CategoryResponse();
		List<Subcategory> subcategories = null;
		cr.setSubcategories(subcategories);
		assertEquals(cr.getSubcategories(), (Subcategory)null);
	}

}