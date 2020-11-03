/**
 * Backend Code Challenge - forked from concretesolutions/java-recruiting-hsa
 * 
 * Author: Jorge Leiva
 * Mail: jorgeleiva.17@gmail.com
 */
package com.concretesolutions.bffinitpage.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/application.properties")
public class ServiceConfig {
  private String categoriesendpoint;
  private String mobileCategory;
  private String couponsendpoint;
  private List<String> listPatterns;
  private String timeZone;

  @Autowired
  public ServiceConfig(@Value("${service.categories.endpoint}") String categoriesendpoint,
      @Value("${service.coupons.endpoint}") String couponsendpoint,
      @Value("${service.categories.mobile}") String mobileCategory,
      @Value("#{'${utils.patterns}'.split(',')}") List<String> listPatterns,
      @Value("${utils.timezone}") String timeZone) {
    this.categoriesendpoint = categoriesendpoint;
    this.couponsendpoint = couponsendpoint;
    this.mobileCategory = mobileCategory;
    this.listPatterns = listPatterns;
    this.timeZone = timeZone;
  }

  public String getCategoriesendpoint() {
    return categoriesendpoint;
  }

  public String getCouponsendpoint() {
    return couponsendpoint;
  }

  public String getMobileCategory() {
    return mobileCategory;
  }

  public List<String> getListPatterns() {
    return listPatterns;
  }

  public String getTimeZone() {
    return timeZone;
  }

}
