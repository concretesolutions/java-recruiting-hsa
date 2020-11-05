package com.accenture.test.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.accenture.test.dto.Coupons;
import com.accenture.test.service.CouponsService;

public class ControllerCouponsTest {
	
	@Mock
    private CouponsService couponsService;

	@InjectMocks
    private CouponsController couponsController;
	    
    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getCouponsNotExpired() {

    	Coupons coupons = new Coupons();
    	coupons.setId("COUPON_1");
    	coupons.setDescription("50% Discount");
    	coupons.setSeller("Crazy Seller");
    	coupons.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
    	LocalDate today = LocalDate.now();
    	coupons.setExpiresAt(today);
    	
    	List<Coupons> list = new ArrayList<Coupons>();
        list.add(coupons);
    	        
        Mockito.when(couponsService.getCouponsNotExpired()).thenReturn(list);

        ResponseEntity<?> result = couponsController.getCouponsNotExpired();

        assertThat(result.getBody()).isNotNull();
    }
}
