/**
 * Backend Code Challenge - forked from concretesolutions/java-recruiting-hsa
 * 
 * Author: Jorge Leiva
 * Mail: jorgeleiva.17@gmail.com
 */
package com.concretesolutions.bffinitpage.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.concretesolutions.bffinitpage.config.ServiceConfig;
import com.concretesolutions.bffinitpage.entities.Coupon;
import com.concretesolutions.bffinitpage.service.CouponsService;
import com.concretesolutions.bffinitpage.utils.ServiceUtils;

@Service
public class CouponsImpl implements CouponsService {

  private static final Logger LOG = LoggerFactory.getLogger(CouponsImpl.class);
  private ServiceConfig serviceConfig;
  private RestTemplate restTemplate;

  @Autowired
  public CouponsImpl(ServiceConfig serviceConfig, RestTemplate restTemplate) {
    this.serviceConfig = serviceConfig;
    this.restTemplate = restTemplate;
  }

  @Override
  @Async
  public CompletableFuture<List<Coupon>> getNotExpired() {
    String url = serviceConfig.getCouponsendpoint();
    LOG.info("Get Coupons not expired from " + url);
    Coupon[] couponsResponse = restTemplate.getForObject(url, Coupon[].class);
    List<Coupon> result = new ArrayList<>();
    ZoneId zid = ZoneId.of(serviceConfig.getTimeZone());
    for (Coupon coupon : couponsResponse) {
      if (ServiceUtils.convertDate(coupon.getExpiresAt(), serviceConfig.getListPatterns())
          .isAfter(LocalDateTime.now(zid))) {
        result.add(coupon);
      }
    }
    return CompletableFuture.completedFuture(result);
  }

}
