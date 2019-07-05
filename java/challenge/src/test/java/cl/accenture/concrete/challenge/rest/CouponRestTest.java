package cl.accenture.concrete.challenge.rest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertNotEquals;
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

import cl.accenture.concrete.challenge.model.Coupon;

import org.junit.FixMethodOrder;

@ExtendWith(SpringExtension.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CouponRestTest {
	@Value("${coupons.api.url.path}")
	String getAllPath;

	@Value("${coupons.api.dt.format:yyyy-MM-dd}")
	private String dtFormat;

	@Autowired
	private TestRestTemplate restTemplate;

	private LocalDateTime startTest, endTest;
	private long delta;

	// 1. testGetCoupons

	@Test
	// This test will verify if the service delivers a list and get the message
	// (normal).
	void testCoupons1() {
		// Test 1: Normal Call.
		startTest = LocalDateTime.now();
		List<?> lst = this.restTemplate.getForObject(getAllPath, ArrayList.class);
		endTest = LocalDateTime.now();

		delta = LocalTime.from(startTest).until(endTest, ChronoUnit.MILLIS);
		assertTrue(lst.size() > 0,
				() -> "There is no data. --" + "Maybe the remote API is down?");
	}

	@Test
	// This test will verify if the service delivers a list and get the message
	// (cached).
	void testCoupons2() {
		// Test 2: Cached Call.
		final int lMarginTime = 200;

		startTest = LocalDateTime.now();
		this.restTemplate.getForObject(getAllPath, ArrayList.class);
		endTest = LocalDateTime.now();

		delta = LocalTime.from(startTest).until(endTest, ChronoUnit.MILLIS);
		assertTrue(delta < lMarginTime, () -> "The response time was more than the expected. --"
				+ "Check if the properties file have a definition for coupons.api.cache.time");
	}

	@Test
	// This test will verify if the normal and cached message is the same.
	void testCoupons3() {

		@SuppressWarnings("unchecked")
		List<Coupon> normalCouponCall = this.restTemplate.getForObject(getAllPath, ArrayList.class);
		@SuppressWarnings("unchecked")
		List<Coupon> cachedCouponCall = this.restTemplate.getForObject(getAllPath, ArrayList.class);

		assertEquals(normalCouponCall, cachedCouponCall);
	}

	// 2. testGetValidCoupons

	@Test
	// This test will verify if the data is still cached & returns the valid
	// coupons.
	void testCoupons4() {
		final int lMarginTime = 200;

		startTest = LocalDateTime.now();
		this.restTemplate.getForObject(getAllPath + "/valid", ArrayList.class);
		endTest = LocalDateTime.now();

		delta = LocalTime.from(startTest).until(endTest, ChronoUnit.MILLIS);
		assertTrue(delta < lMarginTime, () -> "The time was more than the expected. --"
				+ "Check if the properties file have a definition for coupons.api.cache.time");
	}

	@Test
	// This test will verify if the normal and cached message have the same data.
	// As default, the normal and valid coupons have a difference in size.
	void testCoupons5() {
		@SuppressWarnings("unchecked")
		List<Coupon> normalCouponCall = this.restTemplate.getForObject(getAllPath, ArrayList.class);
		@SuppressWarnings("unchecked")
		List<Coupon> validCouponCall = this.restTemplate.getForObject(getAllPath + "/valid", ArrayList.class);
		assertNotEquals(normalCouponCall, validCouponCall);
	}

}
