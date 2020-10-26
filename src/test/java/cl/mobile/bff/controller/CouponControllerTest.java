package cl.mobile.bff.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.mobile.bff.domain.CouponClientResponse;
import cl.mobile.bff.service.interfaces.CouponService;

@SpringBootTest
@AutoConfigureMockMvc
public class CouponControllerTest {
	
	@MockBean
    private CouponService couponService;
	
	@BeforeEach
    public void setup() {
		CouponClientResponse response = new CouponClientResponse();
		response.setId("COUPON1");
		response.setDescription("50% Discount");
		response.setSeller("Some Seller");
		response.setImage("URL");
		response.setExpiresAt("2045-12-01");
		
		List<CouponClientResponse> responseList = new ArrayList<>();
		responseList.add(response);
       Mockito.when(couponService.getCouponNotExpiderd()).thenReturn(responseList);
    }
    @Autowired
    private MockMvc mvc;
    
    @Test
    public void testGetCouponNotExpiderd() throws Exception {
    	CouponClientResponse response = new CouponClientResponse();
		response.setId("COUPON1");
		response.setDescription("50% Discount");
		response.setSeller("Some Seller");
		response.setImage("URL");
		response.setExpiresAt("2045-12-01");
		
		List<CouponClientResponse> responseList = new ArrayList<>();
		responseList.add(response);
		
    	ObjectMapper mapper = new ObjectMapper();
    	String responseListStr = mapper.writeValueAsString(responseList);
    	
       mvc.perform(MockMvcRequestBuilders.get("/bff/mobile/api/coupon/notexpider")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo(responseListStr)));
    }
}
