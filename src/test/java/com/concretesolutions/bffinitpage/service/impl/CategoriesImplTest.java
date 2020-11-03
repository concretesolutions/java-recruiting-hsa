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
import com.concretesolutions.bffinitpage.entities.CategoryTest;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CategoriesImplTest {
  @Mock
  private RestTemplate restTemplate;
  private ServiceConfig serviceConfig = ServiceConfigTest.getEntity();
  CategoriesImpl categoriesImpl;

  @Before
  public void before() {
    categoriesImpl = new CategoriesImpl(serviceConfig, restTemplate);
    Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.any())).thenReturn(CategoryTest.getEntityResponse());
  }

  @Test
  public void testParameter() {
    Assert.assertNotNull(categoriesImpl.getAllCategories(-1));
    Assert.assertNotNull(categoriesImpl.getRemainingTopFiveCategories());
    Assert.assertNotNull(categoriesImpl.getTopFiveCategories());
    Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.any())).thenReturn(CategoryTest.getEntity());
    Assert.assertNotNull(categoriesImpl.getAllCategories(-1));
  }
}
