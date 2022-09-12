package com.accenture.concrete.properties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import com.accenture.concrete.domain.CouponUseCase;

@ConstructorBinding
@ConfigurationProperties(prefix = "concrete.cors")
public class CorsProperties {

	private static final Logger LOG = LogManager.getLogger(CorsProperties.class);

	private List<String> origins = new ArrayList<>();
	
	private List<String> methods = new ArrayList<>();
	
	private List<String> headers = new ArrayList<>();
	
	public CorsProperties(List<String> origins, List<String> methods, List<String> headers) {
		if(origins.contains("*")) {
			LOG.error("this service must no be opened to everyone.");
			throw new IllegalArgumentException("this service must no be opened to everyone.");
		}
		this.origins = Collections.unmodifiableList(origins);
		this.methods = Collections.unmodifiableList(methods);
		this.headers = Collections.unmodifiableList(headers);
	}

	public List<String> allowsOrigins() {
		return this.origins;
	}
	
	public List<String> allowsMethods() {
		return this.methods;
	}
	
	public List<String> allowsHeaders() {
		return this.headers;
	}
	
}