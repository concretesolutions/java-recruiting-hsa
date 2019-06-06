package com.concrete.challenge.apis;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.concrete.challenge.models.CouponResponse;


@RunWith(SpringRunner.class)
@SpringBootTest
public interface CouponApiTest {
	
	@Test
	public default void couponApi_connect() {
		//assertEquals(ca.connect(),"Api coupons ok!");
	}
	
	@Test
	public default void couponApi_getCoupons() {
		CouponResponse cr = new CouponResponse();
		cr.setId("COUPON_1");
		cr.setDescription("50% Discount");
		cr.setSeller("Crazy Seller");
		cr.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		cr.setExpiresAt("2045-12-01");
		
		List<CouponResponse> response = Arrays.asList(cr);
		
		//assertEquals(ca.getCoupons(), response);
	}
}
