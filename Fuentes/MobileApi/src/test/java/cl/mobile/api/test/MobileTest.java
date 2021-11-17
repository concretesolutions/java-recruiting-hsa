package cl.mobile.api.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cl.mobile.api.backend.apiClient.ApiClient;
import cl.mobile.api.backend.controllers.MobileController;
import cl.mobile.api.backend.service.CategoriaService;
import cl.mobile.api.backend.to.CategoriaResponseRest;

public class MobileTest {
	
	@Mock 
	private ApiClient apiClient;

	@Mock	
	private CategoriaService categoriaService;

	@InjectMocks
	private MobileController controller;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}


	@Test
	public void categoriasNoTop5() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(categoriaService.obtieneCategoriasNoTop5()).thenReturn(new ResponseEntity<CategoriaResponseRest>(HttpStatus.OK));
		ResponseEntity<CategoriaResponseRest> response = controller.categoriasNoTop5();
		assertThat(response.getStatusCodeValue()).isEqualTo(200);		
	}

}
