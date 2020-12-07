
package com.accenture.challenge.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.accenture.challenge.mapper.models.Coupon;

@RestController
public class CouponController {

   @Autowired
   RestTemplate restTemplate;

   @RequestMapping(value = "/api/coupons")
   public String getCouponstList() {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <String> entity = new HttpEntity<String>(headers);
      
	  return
		  restTemplate.exchange(
			  "https://cs-hsa-api-coupons.herokuapp.com/coupons", 
			  HttpMethod.GET, 
			  entity, 
			  String.class
			).getBody();
   }
}
