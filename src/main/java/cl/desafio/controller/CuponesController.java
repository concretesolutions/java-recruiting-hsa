package cl.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.desafio.model.Cupon;
import cl.desafio.service.CuponesService;

@RestController
@RequestMapping("/cupones")
public class CuponesController {
	@Autowired
	private CuponesService cuponesService;

	@GetMapping("/v1/activos")
	public List<Cupon> getCuponesActivosCache() {
		return cuponesService.getCuponesCache();
	}

	@GetMapping("/v2/activos")
	public List<Cupon> getCuponesActivosSinCache() {
		return cuponesService.getCuponesSinCache();
	}

}
