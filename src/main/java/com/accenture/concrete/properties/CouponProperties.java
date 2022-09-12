package com.accenture.concrete.properties;

import java.net.URI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "concrete.third-apis.coupon")
public class CouponProperties {

	private static final Logger LOG = LogManager.getLogger(CouponProperties.class);

	private String url;
	
	public CouponProperties(String url) {
		if(!URI.create(url).getScheme().equalsIgnoreCase("https")) {
			LOG.error("schema must be https!");
			throw new IllegalArgumentException("schema must be https!");
		}
		this.url = url;
	}
	
	public URI getUriCoupons() {
		return URI.create(this.url);
	}
	
}
