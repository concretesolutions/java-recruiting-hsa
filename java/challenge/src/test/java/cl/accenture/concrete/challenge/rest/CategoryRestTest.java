package cl.accenture.concrete.challenge.rest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cl.accenture.concrete.challenge.model.Category;

import org.junit.FixMethodOrder;

@ExtendWith(SpringExtension.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CategoryRestTest {
	@Value("${categories.api.url.path}")
	String getAllPath;

	@Value("${categories.api.dt.format:yyyy-MM-dd}")
	private String dtFormat;

	@Autowired
	private TestRestTemplate restTemplate;

	private LocalDateTime startTest, endTest;
	private long delta;

	// 1. testGetCategories

	@Test
	// This test will verify if the service delivers a list and get the message
	// (normal).
	void testCategories1() {
		// Test 1: Normal Call.
		Category c = this.restTemplate.getForObject(getAllPath, Category.class);

		assertTrue(c != null, () -> "There is no data. --" + "Maybe the remote API is down?");
	}

	@Test
	// This test will verify if the service delivers a list and get the message
	// (cached).
	void testCategories2() {
		// Test 2: Cached Call.
		final int lMarginTime = 200;

		startTest = LocalDateTime.now();
		this.restTemplate.getForObject(getAllPath, Category.class);
		endTest = LocalDateTime.now();

		delta = LocalTime.from(startTest).until(endTest, ChronoUnit.MILLIS);
		assertTrue(delta < lMarginTime, () -> "The response time was more than the expected. --"
				+ "Check if the properties file have a definition for coupons.api.cache.time");
	}

	// 2. testGetTopCategories

	@Test
	// This test will verify if the data is still cached & returns the top 5 categories.
	void testCategories3() {
		final int lMarginTime = 200;

		startTest = LocalDateTime.now();
		this.restTemplate.getForObject(getAllPath + "/top/5", ArrayList.class);
		endTest = LocalDateTime.now();

		delta = LocalTime.from(startTest).until(endTest, ChronoUnit.MILLIS);
		assertTrue(delta < lMarginTime, () -> "The time was more than the expected. --"
				+ "Check if the properties file have a definition for categories.api.cache.time");
	}

	@Test
	// This test will verify if the top 5 returns the 5 most relevant categories.
	void testCategories4() {
		@SuppressWarnings("unchecked")
		List<Category> validCouponCall = this.restTemplate.getForObject(getAllPath + "/top/5", ArrayList.class);
		assertEquals(validCouponCall.size(), 5);
	}
	
	
	@Test
	// This test will verify if the data is still cached & returns the rest of categories.
	void testCategories5() {
		final int lMarginTime = 200;

		startTest = LocalDateTime.now();
		this.restTemplate.getForObject(getAllPath + "/notop/5", ArrayList.class);
		endTest = LocalDateTime.now();

		delta = LocalTime.from(startTest).until(endTest, ChronoUnit.MILLIS);
		assertTrue(delta < lMarginTime, () -> "The time was more than the expected. --"
				+ "Check if the properties file have a definition for categories.api.cache.time");
	}

}
