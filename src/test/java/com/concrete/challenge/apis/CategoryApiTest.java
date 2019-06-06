package com.concrete.challenge.apis;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.concrete.challenge.models.CategoryResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public interface CategoryApiTest {
	
	@Test
	public default void categoryApi_connect() {
		//assertEquals(ca.connect(),"Api categories ok!");
	}
	
	@Test
	public default void categoryApi_getCoupons() {
		//assertEquals(ca.getCategories(), (List<CategoryResponse>)null);
	}
}