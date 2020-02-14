package cl.accenture.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApiMobileApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate = new TestRestTemplate();

	@LocalServerPort
	private int port;

	@Test
	void testGetCouponsNotExpired() {
		HttpHeaders headers = new HttpHeaders();
		try {

			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAcceptCharset(Arrays.asList(StandardCharsets.UTF_8));
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			HttpEntity<?> request = new HttpEntity<>(headers);

			ResponseEntity<List> response = restTemplate.exchange(
					"http://localhost:" + port + "/api/mobile/coupons/not_expired", HttpMethod.GET, request,
					List.class);

			assertEquals(HttpStatus.OK, response.getStatusCode());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error testGetCouponsNotExpired.");
		}
	}

	@Test
	void testGetCarruselCategories() {
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAcceptCharset(Arrays.asList(StandardCharsets.UTF_8));
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			HttpEntity<?> request = new HttpEntity<>(headers);

			ResponseEntity<List> response = restTemplate.exchange(
					"http://localhost:" + port + "/api/mobile/categories/carrusel", HttpMethod.GET, request,
					List.class);

			assertEquals(HttpStatus.OK, response.getStatusCode());
			
		} catch (Exception e) {
			fail("Error testGetCarruselCategories. ");
		}
	}
	
	@Test
	void testGetRemainingCategories() {
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAcceptCharset(Arrays.asList(StandardCharsets.UTF_8));
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			HttpEntity<?> request = new HttpEntity<>(headers);

			ResponseEntity<List> response = restTemplate.exchange(
					"http://localhost:" + port + "/api/mobile/categories/remaining", HttpMethod.GET, request,
					List.class);

			assertEquals(HttpStatus.OK, response.getStatusCode());
			
		} catch (Exception e) {
			fail("Error testGetRemainingCategories. ");
		}
	}

}
