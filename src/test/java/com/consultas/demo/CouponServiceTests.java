package com.consultas.demo;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.consultas.demo.dto.CouponResponse;
import com.consultas.demo.service.CouponService;
import com.consultas.demo.service.CouponSeviceImpl;
import com.consultas.demo.service.CouponsServiceRestClient;

@RunWith(MockitoJUnitRunner.class)
public class CouponServiceTests {
	
    @Mock
    private CouponsServiceRestClient couponsServiceRestClient;
	private CouponService couponService;
	
    @Before
    public void setup() {
    	couponService = new CouponSeviceImpl(couponsServiceRestClient);
    }
	
	@Test
	public void getCuponsValidOkTest() {
		
		List<CouponResponse> listCouponResponse = new ArrayList<CouponResponse>();
		CouponResponse couponResponse = new CouponResponse();
		couponResponse.setSeller("juan");
		couponResponse.setExpiresAt("2042-12-25");
		couponResponse.setId("1111");
		couponResponse.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		listCouponResponse.add(couponResponse);
		
		couponResponse = new CouponResponse();
		couponResponse.setSeller("juana");
		couponResponse.setExpiresAt("2046-12-25");
		couponResponse.setId("1122");
		couponResponse.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		listCouponResponse.add(couponResponse);
		
		when(couponsServiceRestClient.getCoupons()).thenReturn(listCouponResponse);
		List<CouponResponse> listCoupon = couponService.getValidCoupons();
		assertTrue(!listCoupon.isEmpty());
		
	}
	
	@Test
	public void getCuponsValidEmptyTestException() {
		
		List<CouponResponse> listCouponExpiredResponse = new ArrayList<CouponResponse>();
		CouponResponse couponResponse = new CouponResponse();
		couponResponse.setSeller("juan");
		couponResponse.setExpiresAt("2011-12-25");
		couponResponse.setId("1111");
		couponResponse.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		listCouponExpiredResponse.add(couponResponse);
		
		couponResponse = new CouponResponse();
		couponResponse.setSeller("juana");
		couponResponse.setExpiresAt("2011-12-25");
		couponResponse.setId("1122");
		couponResponse.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		listCouponExpiredResponse.add(couponResponse);
		
		when(couponsServiceRestClient.getCoupons()).thenReturn(listCouponExpiredResponse);
		List<CouponResponse> listCoupon = couponService.getValidCoupons();
		assertTrue(listCoupon.isEmpty());
		
	}

}
