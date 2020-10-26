package cl.mobile.bff.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cl.mobile.bff.client.interfaces.CouponClient;
import cl.mobile.bff.domain.CouponClientResponse;
import cl.mobile.bff.service.interfaces.CouponService;

@SpringBootTest
public class CouponServiceTest {
	
	@Mock
    private CouponClient couponClient;
	
	@InjectMocks
    private CouponService couponService = new CouponServiceImpl();
	
	@BeforeEach
    void setMockOutput() {
		
		CouponClientResponse coupon1 = new CouponClientResponse();
		coupon1.setId("COUPON1");
		coupon1.setDescription("50% Discount");
		coupon1.setSeller("Some Seller");
		coupon1.setImage("URL");
		coupon1.setExpiresAt("2045-12-01");
		
		CouponClientResponse coupon2 = new CouponClientResponse();
		coupon2.setId("COUPON2");
		coupon2.setDescription("50% Discount");
		coupon2.setSeller("Some Seller2");
		coupon2.setImage("URL");
		coupon2.setExpiresAt("2018-12-01");
		
		List<CouponClientResponse> responseMock = new ArrayList<>();
		responseMock.add(coupon1);
		responseMock.add(coupon2);
		
		when(couponClient.getCoupons()).thenReturn(responseMock);
	}
	
	@DisplayName("Test getCouponNotExpiderd method")
	@Test
    void testCouponNotExpired() throws JsonProcessingException {
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
		String serviceResponse = mapper.writeValueAsString(couponService.getCouponNotExpiderd());
		
		assertEquals(responseListStr, serviceResponse);
    }

}
