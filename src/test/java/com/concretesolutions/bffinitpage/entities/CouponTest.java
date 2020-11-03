/**
 * Backend Code Challenge - forked from concretesolutions/java-recruiting-hsa
 * 
 * Author: Jorge Leiva
 * Mail: jorgeleiva.17@gmail.com
 */
package com.concretesolutions.bffinitpage.entities;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.concretesolutions.bffinitpage.ConstantsTest;


@RunWith(MockitoJUnitRunner.class)
public class CouponTest {
  @Test
  public void testParameters() {
    Coupon entity = getEntity();
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity);
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getDescription());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getExpiresAt());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getId());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getImage());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getSeller());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.toString());
  }

  public static Coupon getEntity() {
    Coupon result = new Coupon();
    result.setId("123");
    result.setDescription("description");
    result.setExpiresAt("2020-01-12");
    result.setImage("image");
    result.setSeller("seller");
    return result;
  }

  public static List<Coupon> getList() {
    List<Coupon> list = new ArrayList<>();
    list.add(getEntity());
    return list;
  }
}
