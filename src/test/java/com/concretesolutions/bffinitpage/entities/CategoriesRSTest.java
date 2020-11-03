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
public class CategoriesRSTest {
  @Test
  public void testParameters() {
    CategoriesRS entity = getEntity();
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity);
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getRemainingCategories());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getTopCategories());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, getList());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.toString());
  }

  public static CategoriesRS getEntity() {
    CategoriesRS result = new CategoriesRS();
    result.getRemainingCategories();
    result.setRemainingCategories(CategoryTest.getList());
    result.getTopCategories();
    result.setTopCategories(CategoryTest.getList());
    return result;
  }

  public static List<CategoriesRS> getList() {
    List<CategoriesRS> list = new ArrayList<>();
    list.add(getEntity());
    return list;
  }
}
