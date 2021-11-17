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
import cl.mobile.api.backend.serviceImpl.CategoriaServiceImpl;
import cl.mobile.api.backend.to.CategoriaResponseRest;
//@SpringBootTest
public class CategoriaServiceTest {
	
private String CATEGORIAS_RESPONSE  = "{\"id\":\"ROOT\",\"name\":\"LEGACY_NAVIGATION\",\"subcategories\":[{\"id\":\"MOB\",\"name\":\"MOBILE_MARKET\",\"subcategories\":[{\"id\":\"video-games\",\"name\":\"Video Games\",\"relevance\":150,\"subcategories\":[{\"id\":\"nintendo\",\"name\":\"Nintendo\",\"subcategories\":[{\"id\":\"switch\",\"name\":\"Switch\",\"relevance\":422}],\"largeImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"mediumImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"smallImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"}],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"},{\"id\":\"sports\",\"name\":\"Sports\",\"relevance\":1,\"subcategories\":[{\"id\":\"bike\",\"name\":\"Bike\",\"relevance\":350,\"subcategories\":[],\"largeImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"mediumImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"smallImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"}],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"},{\"id\":\"electronics\",\"name\":\"Electronics\",\"subcategories\":[{\"id\":\"tv\",\"name\":\"TV\",\"subcategories\":[{\"id\":\"4k\",\"name\":\"4K\",\"relevance\":700}],\"largeImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"mediumImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"smallImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"}],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"},{\"id\":\"outdoor\",\"name\":\"Outdoor\",\"relevance\":3,\"subcategories\":[],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"},{\"id\":\"food\",\"name\":\"Food\",\"relevance\":4,\"subcategories\":[{\"id\":\"hamburger\",\"name\":\"Hamburger\",\"relevance\":350,\"subcategories\":[],\"largeImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"mediumImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"smallImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"}],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"},{\"id\":\"books\",\"name\":\"Books\",\"relevance\":2,\"subcategories\":[],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"},{\"id\":\"travel\",\"name\":\"Travel\",\"relevance\":5,\"subcategories\":[],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"},{\"id\":\"health\",\"name\":\"Health\",\"relevance\":6,\"subcategories\":[],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"},{\"id\":\"toys\",\"name\":\"Toys\",\"relevance\":99,\"subcategories\":[{\"id\":\"puzzles\",\"name\":\"Puzzles\",\"relevance\":100,\"subcategories\":[],\"largeImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"mediumImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"smallImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"}],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"}]}]}";
	
	@Mock 
	private ApiClient apiClient;
	
	
	@InjectMocks	
	private CategoriaServiceImpl categoriaService;
	

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test 
	public void llamadaApiCategoriasNoTop5() 
	{
		when(apiClient.obtieneCategorias()).thenReturn(CATEGORIAS_RESPONSE);
		ResponseEntity<CategoriaResponseRest> response = categoriaService.obtieneCategoriasNoTop5();
		assertThat(response.getStatusCodeValue()).isEqualTo(200);		
		
	}
	
	
	@Test 
	public void llamadaApiCategoriasNoTop5Nok() 
	{
		when(apiClient.obtieneCategorias()).thenReturn(null);
		ResponseEntity<CategoriaResponseRest> response = categoriaService.obtieneCategoriasNoTop5();
		assertThat(response.getStatusCodeValue()).isEqualTo(500);		
		
	}
	@Test 
	public void llamadaApiCategoriasTop5() 
	{
		when(apiClient.obtieneCategorias()).thenReturn(CATEGORIAS_RESPONSE);
		ResponseEntity<CategoriaResponseRest> response = categoriaService.obtieneCategoriasTop5();
		assertThat(response.getStatusCodeValue()).isEqualTo(200);		
		
	}
	
	@Test 
	public void llamadaApiCategoriasTop5Nok() 
	{
		when(apiClient.obtieneCategorias()).thenReturn(null);
		ResponseEntity<CategoriaResponseRest> response = categoriaService.obtieneCategoriasTop5();
		assertThat(response.getStatusCodeValue()).isEqualTo(500);		
		
	}

	
	

}
