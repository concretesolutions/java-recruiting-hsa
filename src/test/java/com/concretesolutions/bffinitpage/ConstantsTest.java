/**
 * Backend Code Challenge - forked from concretesolutions/java-recruiting-hsa
 * 
 * Author: Jorge Leiva
 * Mail: jorgeleiva.17@gmail.com
 */
package com.concretesolutions.bffinitpage;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

public class ConstantsTest {
  public static final String MUST_BE_A_TRUE = "expected a true value";
  public static final String MUST_BE_A_FALSE = "expected a false value";
  public static final String MUST_BE_A_NULL = "expected a null value";
  public static final String MUST_BE_A_NOTNULL = "can't be a null value";
  public static final String MUST_BE_A_EQUALS = "expected value equals to '%s'";
  public static final String MUST_BE_A_NOTEQUALS = "expected value not equals to '%s'";
  
  @Test
  public void testContantsTest() throws NoSuchMethodException, SecurityException, InstantiationException,
          IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Constructor<ConstantsTest> duConts = ConstantsTest.class.getDeclaredConstructor();
    ConstantsTest contantsTest = duConts.newInstance((Object[]) null);
    Assert.assertNotNull("Constants cant be a null", contantsTest);
  }
}
