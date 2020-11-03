package com.concretesolutions.bffinitpage.config;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.concretesolutions.bffinitpage.ConstantsTest;

public class ServiceConfigTest {
  @Test
  public void testParameters() {
    ServiceConfig entity = getEntity();
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity);
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getCategoriesendpoint());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getCouponsendpoint());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getListPatterns());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getMobileCategory());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getTimeZone());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.toString());
  }

  public static ServiceConfig getEntity() {
    ServiceConfig result = new ServiceConfig("categoriesendpoint", "couponsendpoint", "MOBILE_MARKET",
        getListPatterns(), "Chile/Continental");
    return result;
  }

  public static List<String> getListPatterns() {
    List<String> patterns = new ArrayList<>();
    patterns.add("yyyy-MM-dd HH");
    patterns.add("yyyy-MM-dd HH:mm");
    patterns.add("yyyy-MM-dd HH:mm:ss");
    return patterns;
  }
}
