package com.concretesolutions.bffinitpage.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.concretesolutions.bffinitpage.config.ServiceConfig;
import com.concretesolutions.bffinitpage.config.ServiceConfigTest;
import com.concretesolutions.bffinitpage.entities.Coupon;
import com.concretesolutions.bffinitpage.entities.CouponTest;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CouponsImplTest {
  @Mock
  private RestTemplate restTemplate;
  private ServiceConfig serviceConfig = ServiceConfigTest.getEntity();
  CouponsImpl couponsImpl;
  
  @Before
  public void before() {
    Coupon[] couponsArray = new Coupon[2];
    couponsArray[0] = CouponTest.getEntity();
    couponsArray[1] = CouponTest.getEntity();
    couponsArray[1].setExpiresAt("2090-01-12");
    couponsImpl = new CouponsImpl(serviceConfig, restTemplate);
    Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.any())).thenReturn(couponsArray);
  }
  
  @Test
  public void testParameter() {
    Assert.assertNotNull(couponsImpl.getNotExpired());
  }

}
