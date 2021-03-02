package cl.desafio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cl.desafio.controller.CuponesController;
import cl.desafio.model.Cupon;
import cl.desafio.service.CuponService;
import cl.desafio.service.CuponesService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

class CuponesApplicationTests {

	@MockBean
	private CuponService cuponService;

	@Autowired
	private CuponesService cuponesService;
	@Autowired
	private CuponesController cuponesController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(cuponesController).isNotNull();
	}

	@Test
	void emptyListResult() {
		final List<Cupon> cuponesVigentes = cuponesService.getCuponesCache();
		assertThat(cuponesVigentes).isNotEmpty();
	}

	@Test
	// valida que filtro funcione con mock
	void ListResult() {
		when(cuponService.getCupones()).thenReturn(Stream.of(
				new Cupon("id1", "description1", "seller1", "url_image1", new Date(new Date().getTime() + 86400000)),
				new Cupon("id2", "description2", "seller2", "url_image2", new Date(new Date().getTime() - 86400000)),
				new Cupon("id3", "description3", "seller3", "url_image3", new Date(new Date().getTime() - 86400000)),
				new Cupon("id4", "description4", "seller4", "url_image4", new Date(new Date().getTime() + 86400000)))
				.collect(Collectors.toList()));
		assertThat(cuponesController.getCuponesActivosCache()).hasSize(2);
		assertThat(cuponesController.getCuponesActivosSinCache()).hasSize(2);
	}

}