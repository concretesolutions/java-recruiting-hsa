package com.concretesolutions.bffinitpage.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.concretesolutions.bffinitpage.ConstantsTest;

@RunWith(MockitoJUnitRunner.class)
public class ServiceUtilsTest {
  @Test
  public void testParameters() {
    List<String> patterns = new ArrayList<>();
    patterns.add("yyyy-MM-dd HH");
    patterns.add("yyyy-MM-dd HH:mm");
    patterns.add("yyyy-MM-dd HH:mm:ss");
    Assert.assertFalse(ConstantsTest.MUST_BE_A_FALSE, ServiceUtils.isNonEmpty(null));
    Assert.assertFalse(ConstantsTest.MUST_BE_A_FALSE, ServiceUtils.isNonEmpty(""));
    Assert.assertTrue(ConstantsTest.MUST_BE_A_TRUE, ServiceUtils.isNonEmpty("value"));
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL,ServiceUtils.convertDate(null, patterns));
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL,ServiceUtils.convertDate("", patterns));
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL,ServiceUtils.convertDate("2020-01-12", patterns));
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL,ServiceUtils.convertDate("2020-01-12 12:12:12", patterns));
  }
}
