package com.concrete.challenge.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponResponseTest {
    
    @Test
	public void categoryResponse_getId_setId() {
		CouponResponse cr = new CouponResponse();
		cr.setId("COUPON_1");
		assertEquals(cr.getId(), "COUPON_1");
	}
    
    @Test
	public void categoryResponse_getDescription_setDescription() {
		CouponResponse cr = new CouponResponse();
		cr.setDescription("50% Discoun");
		assertEquals(cr.getDescription(), "50% Discoun");
	}
    
    @Test
	public void categoryResponse_getSeller_setSeller() {
		CouponResponse cr = new CouponResponse();
		cr.setSeller("Crazy Selle");
		assertEquals(cr.getSeller(), "Crazy Selle");
	}
    
    @Test
	public void categoryResponse_getImage_setImage() {
		CouponResponse cr = new CouponResponse();
		cr.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		assertEquals(cr.getImage(), "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
	}
    
    @Test
	public void categoryResponse_getExpiresAt_setExpiresAt() {
		CouponResponse cr = new CouponResponse();
		cr.setExpiresAt("2045-12-01");
		assertEquals(cr.getExpiresAt(), "2045-12-01");
	}
    
}
