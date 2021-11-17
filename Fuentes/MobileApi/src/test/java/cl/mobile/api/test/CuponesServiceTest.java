package cl.mobile.api.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import cl.mobile.api.backend.apiClient.ApiClient;
import cl.mobile.api.backend.serviceImpl.CuponesServiceImpl;
import cl.mobile.api.backend.to.CuponesResponseRest;


public class CuponesServiceTest {

	
	private String CUPONES_RESPONSE = "[{\"id\":\"COUPON_1\",\"description\":\"50% Discount\",\"seller\":\"Crazy Seller\",\"image\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"expiresAt\":\"2045-12-01\"},{\"id\":\"COUPON_2\",\"description\":\"5% Discount\",\"seller\":\"The Seller\",\"image\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"expiresAt\":\"2042-12-25\"},{\"id\":\"COUPON_3\",\"description\":\"100% Discount\",\"seller\":\"Old Seller\",\"image\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"expiresAt\":\"2018-10-01\"},{\"id\":\"COUPON_4\",\"description\":\"1% Discount\",\"seller\":\"Mega Discount\",\"image\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"expiresAt\":\"2055-10-01\"},{\"id\":\"COUPON_5\",\"description\":\"100% Discount\",\"seller\":\"The Discount\",\"image\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"expiresAt\":\"2016-11-01\"}]\r\n"
			+ "";
		
	@Mock
	private ApiClient apiClient;

	@InjectMocks
	private CuponesServiceImpl cuponesService;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	
	@Test 
	public void llamadaObtieneCupones() 
	{
		when(apiClient.obtieneCupones()).thenReturn(CUPONES_RESPONSE);
		ResponseEntity<CuponesResponseRest> response = cuponesService.obtieneCuponesVigentes();
		assertThat(response.getStatusCodeValue()).isEqualTo(200);		
		
	}
	
	@Test 
	public void llamadaObtieneCuponesNok() 
	{
		when(apiClient.obtieneCupones()).thenReturn(null);
		ResponseEntity<CuponesResponseRest> response = cuponesService.obtieneCuponesVigentes();
		assertThat(response.getStatusCodeValue()).isEqualTo(500);		
		
	}
	
	

}
