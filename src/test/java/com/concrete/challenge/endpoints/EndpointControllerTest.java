package com.concrete.challenge.endpoints;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.concrete.challenge.apis.CategoryApi;
import com.concrete.challenge.apis.CouponApi;
import com.concrete.challenge.models.CategoryResponse;
import com.concrete.challenge.models.CouponResponse;
import com.concrete.challenge.models.Subcategory;
import com.concrete.challenge.models.Subcategory_;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EndpointControllerTest {
	
	@Mock
	CouponApi ca;
	
	@Mock
	CategoryApi catApi;
	
	private MockMvc mockMvc;
	
	@InjectMocks
	EndpointController ec;
	
	@Before(value = "")
    public void setUp() {
       this.mockMvc = MockMvcBuilders.standaloneSetup(ec).build();
    }
    
	@Test
	public void EndpointController_home() throws Exception {
		this.mockMvc = MockMvcBuilders.standaloneSetup(ec).build();
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
		assertEquals(ec.home(), "Mapping for /");
	}
	
	@Test
	public void EndpointController_healthCheck() throws Exception {
		this.mockMvc = MockMvcBuilders.standaloneSetup(ec).build();
		this.mockMvc.perform(get("/challenge/healthcheck")).andExpect(status().isOk());
		assertEquals(ec.healthCheck(), "\"healthy\"");
	}
	
	@Test
	public void EndpointController_getAllCoupons() throws Exception {
		
		CouponResponse cr = new CouponResponse();
		cr.setId("COUPON_1");
		cr.setDescription("50% Discount");
		cr.setSeller("Crazy Seller");
		cr.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		cr.setExpiresAt("2045-12-01");
		
		when(ec.getAllCoupons()).thenReturn(Arrays.asList(cr));
		
		List<CouponResponse> response = Arrays.asList(cr);
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(ec).build();
		this.mockMvc.perform(get("/challenge/coupons")).andExpect(status().isOk());
		assertEquals(ec.getAllCoupons(), response);
	}
	
	@Test
	public void EndpointController_getCouponsNotExpired() throws Exception {
		
		CouponResponse cr = new CouponResponse();
		cr.setId("COUPON_1");
		cr.setDescription("50% Discount");
		cr.setSeller("Crazy Seller");
		cr.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		cr.setExpiresAt("2045-12-01");
		
		when(ec.getCouponsNotExpired()).thenReturn(Arrays.asList(cr));
		
		List<CouponResponse> response = Arrays.asList(cr);
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(ec).build();
		this.mockMvc.perform(get("/challenge/coupons/not-expired")).andExpect(status().isOk());
		assertEquals(ec.getCouponsNotExpired(), response);
	}
	
	@Test
	public void EndpointController_getAllCategories() throws Exception {
		ArrayList<Subcategory_> subcategories_ = null;
		
		Subcategory sc = new Subcategory();
		sc.setId("MOB");
		sc.setName("MOBILE_MARKET");
		sc.setSubcategories(subcategories_);
		
		List<Subcategory> subcategories = Arrays.asList(sc);
		
		CategoryResponse cr = new CategoryResponse();
		cr.setId("ROOT");
		cr.setName("LEGACY_NAVIGATION");
		cr.setSubcategories(subcategories);
		
		when(ec.getAllCategories()).thenReturn(cr);
		
		CategoryResponse response = cr;
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(ec).build();
		this.mockMvc.perform(get("/challenge/categories")).andExpect(status().isOk());
		assertEquals(ec.getAllCategories(), response);
	}
	
	@Test
	public void EndpointController_getCategoriesTopFive() throws Exception {
		/*ArrayList<Subcategory__> subcategories__ = null;
		
		Subcategory_ sc_ = new Subcategory_();
		sc_.setId("video-games");
	    sc_.setName("Video Games");
	    sc_.setRelevance(150);
	    sc_.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
	    sc_.setSubcategories(subcategories__);
		
		ArrayList<Subcategory_> subcategories_ = new ArrayList<Subcategory_>();
		subcategories_.add(sc_);
		
		Subcategory sc = new Subcategory();
		sc.setId("MOB");
		sc.setName("MOBILE_MARKET");
		sc.setSubcategories(subcategories_);
		
		List<Subcategory> subcategories = Arrays.asList(sc);
		
		CategoryResponse cr = new CategoryResponse();
		cr.setId("ROOT");
		cr.setName("LEGACY_NAVIGATION");
		cr.setSubcategories(subcategories);
		
		//when(catApi.getCategories().getSubcategories().get(0).getSubcategories()).thenReturn(subcategories_);
		//when(catApi.getCategories().getSubcategories().get(0)).thenReturn(sc);
		//when(catApi.getCategories().getSubcategories()).thenReturn(subcategories);
		//when(catApi.getCategories()).thenReturn(cr);
		
		CustomCategory cc = new CustomCategory();
		cc.setName("Video Games");
		cc.setRelevance(150);
		cc.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		cc.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		
		ArrayList<CustomCategory> response = new ArrayList<CustomCategory>();
		response.add(cc);
		
		//when(ec.getCategoriesTopFive()).thenReturn(response);
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(ec).build();
		this.mockMvc.perform(get("/challenge/categories/top-five")).andExpect(status().isOk());
		//assertEquals(ec.getCategoriesTopFive(), response);
		*/
	}
    
}
