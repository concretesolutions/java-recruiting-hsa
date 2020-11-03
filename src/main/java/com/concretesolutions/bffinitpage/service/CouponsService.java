/**
 * Backend Code Challenge - forked from concretesolutions/java-recruiting-hsa
 * 
 * Author: Jorge Leiva
 * Mail: jorgeleiva.17@gmail.com
 */
package com.concretesolutions.bffinitpage.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.concretesolutions.bffinitpage.entities.Coupon;


public interface CouponsService {
  public CompletableFuture<List<Coupon>> getNotExpired();
}
