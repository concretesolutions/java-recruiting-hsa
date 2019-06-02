package com.aptiliux.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.aptiliux.dto.category.Category;
import com.aptiliux.dto.category.CategoryDTO;
import com.aptiliux.dto.coupon.CouponDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CouponServiceTest {

	@Autowired
	private CouponService couponService;
	
	@MockBean
    private RestTemplate restTemplate;
	
	private List<CouponDTO> coupon;
	
	@SuppressWarnings("unchecked")
	@Before
    public void InitialData() {
		this.coupon = loadJson("src/test/resources/coupons.json",new TypeReference<List<CouponDTO>>(){});
		when(restTemplate.exchange(
				any(String.class), 
				eq(HttpMethod.GET),
				eq(null),
				eq(new ParameterizedTypeReference<List<CouponDTO>>() {})))
		.thenReturn(new ResponseEntity<List<CouponDTO>>(coupon, HttpStatus.OK));
		
	}
	
	
	@Test
	public void shoulReturnAllCategoriesWithRelevance() {

		List<CouponDTO> coupons = couponService.getNonExpiredCoupons();
		assertEquals(3,coupons.size());
	}

	
    private <T> T loadJson(final String path, TypeReference<T> type) {
        File jFile = new File(path);

        ObjectMapper jObject = new ObjectMapper();
        jObject.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return jObject.readValue(jFile, type);
        } catch (IOException e) {
            return null;
        }
    }

}
