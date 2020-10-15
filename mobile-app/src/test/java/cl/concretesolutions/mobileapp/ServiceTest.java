package cl.concretesolutions.mobileapp;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import cl.concretesolutions.mobileapp.api.category.CategoryClient;
import cl.concretesolutions.mobileapp.api.category.CategoryDto;
import cl.concretesolutions.mobileapp.api.category.CategoryTree;
import cl.concretesolutions.mobileapp.api.category.service.CategoryService;
import cl.concretesolutions.mobileapp.api.coupon.CouponClient;
import cl.concretesolutions.mobileapp.api.coupon.CouponDto;
import cl.concretesolutions.mobileapp.api.coupon.service.CouponService;

@SpringBootTest
public class ServiceTest {
	
	@Mock
	private CouponClient client;
	
	@Mock
	private CategoryClient clientCategory;
	
	
	@Test
	public void getCoupons() throws Exception {
		CouponService service = new CouponService(client);
		
		List<CouponDto> lista = new ArrayList<CouponDto>();
		CouponDto coupon = new CouponDto();
		coupon.setId("1");
		coupon.setSeller("abc");
		coupon.setExpiresAt("2025-01-01");
		
		lista.add(coupon);
		
		when(client.getCoupons()).thenReturn(lista);
		
		List<CouponDto> resultado = service.getCoupons();
		
		Assert.assertEquals("1", resultado.get(0).getId());
	}
	
	
	@Test
	public void getCategories() throws Exception {
		CategoryService service = new CategoryService(clientCategory);
		
		CategoryTree category = new CategoryTree();
		category.setId("2");
		category.setName("xyz");
		category.setRelevance(1);
		
		List<CategoryTree> lista = new ArrayList<CategoryTree>();
		lista.add(category);
		
		CategoryTree category2 = new CategoryTree();
		category2.setId("1");
		category2.setName("abc");
		category2.setRelevance(1);
		category2.setSubcategories(lista);
		
		
		when(clientCategory.getCategories()).thenReturn(category2);
		
		List<CategoryDto> resultado = service.getCategories();
		
		Assert.assertEquals("2", resultado.get(0).getId());
		Assert.assertEquals(1, resultado.size());
	}
	
	
	@Test
	public void getTopNCategories() throws Exception {
		CategoryService service = new CategoryService(clientCategory);
		
		CategoryTree category = new CategoryTree();
		category.setId("2");
		category.setName("xyz");
		category.setRelevance(1);
		
		List<CategoryTree> lista = new ArrayList<CategoryTree>();
		lista.add(category);
		
		CategoryTree category2 = new CategoryTree();
		category2.setId("1");
		category2.setName("abc");
		category2.setRelevance(1);
			
		CategoryTree category3 = new CategoryTree();
		category3.setId("1");
		category3.setName("abc");
		category3.setRelevance(1);
		lista.add(category3);
		
		category2.setSubcategories(lista);
		
		when(clientCategory.getCategories()).thenReturn(category2);
		
		List<CategoryDto> resultado = service.getTopNCategories(1);
		System.out.println(resultado);
		Assert.assertEquals("2", resultado.get(0).getId());
		Assert.assertEquals(2, resultado.size());
		Assert.assertEquals(false, resultado.get(1).isTop());
	}
}
