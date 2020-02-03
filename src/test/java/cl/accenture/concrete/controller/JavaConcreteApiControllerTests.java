package cl.accenture.concrete.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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

import cl.accenture.concrete.domain.BasicCategory;
import cl.accenture.concrete.domain.DataCoupon;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class JavaConcreteApiControllerTests {
 
	@Autowired
    private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	@Test
	void testGetTopFiveCategories() {
		
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAcceptCharset(Arrays.asList(StandardCharsets.UTF_8)); 
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<?> request = new HttpEntity<>(headers);
		    ResponseEntity<List> response = restTemplate.exchange("http://localhost:"+port+"/backend/api/categories/top5", HttpMethod.GET, request, List.class);
		    List<BasicCategory> categories = response.getBody();
			assertEquals(HttpStatus.OK, response.getStatusCode());
			assertNotEquals(null, categories, "No existen categorias");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error de respuesta");
		}
	}
	
	@Test
	void testGetValidsCoupons() {
		
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAcceptCharset(Arrays.asList(StandardCharsets.UTF_8)); 
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<?> request = new HttpEntity<>(headers);
		    ResponseEntity<List> response = restTemplate.exchange("http://localhost:"+port+"/backend/api/coupons", HttpMethod.GET, request, List.class);
		    List<DataCoupon> coupons = response.getBody();
			assertEquals(HttpStatus.OK, response.getStatusCode());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error de respuesta");
		}
	}
	
	@Test
	void testGetRemainingCategories() {
		
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAcceptCharset(Arrays.asList(StandardCharsets.UTF_8)); 
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<?> request = new HttpEntity<>(headers);
		    ResponseEntity<List> response = restTemplate.exchange("http://localhost:"+port+"/backend/api/categories/remaining", HttpMethod.GET, request, List.class);
		    List<BasicCategory> categories = response.getBody();
			assertEquals(HttpStatus.OK, response.getStatusCode());
			assertNotEquals(null, categories, "No existen categorias");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error de respuesta");
		}
	}

}
