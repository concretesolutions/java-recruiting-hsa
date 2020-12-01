package cl.recruiting.hsa.proyecto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import cl.recruiting.hsa.proyecto.data.model.DataCategory;
import cl.recruiting.hsa.proyecto.data.model.DataCoupon;
import cl.recruiting.hsa.proyecto.data.service.DataCategoryService;
import cl.recruiting.hsa.proyecto.data.service.DataCouponService;
import cl.recruiting.hsa.proyecto.legacy.model.SubcategoryPrimerNivel;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class DatosController {
	
	@Autowired
	private DataCategoryService dataCategoryService;
	
	@Autowired
	private DataCouponService dataCouponService;
	
	@ApiOperation("Top 5 categorías")
	@GetMapping(value={"top5-categorias.json"})
	//@PreAuthorize("TODO")
	public List<SubcategoryPrimerNivel> top5Categories() {
		Gson gson = new Gson();
		List<DataCategory> listaCategorias = dataCategoryService.top5Categories();
		List<SubcategoryPrimerNivel> top5Categorias = new ArrayList<>();
		for(DataCategory dataCategory: listaCategorias) {
			SubcategoryPrimerNivel subcategoryPrimerNivel = gson.fromJson(dataCategory.getDatosJson(), SubcategoryPrimerNivel.class);
			top5Categorias.add(subcategoryPrimerNivel);
		}
		return top5Categorias;
	}
	
	@ApiOperation("Categorías restantes")
	@GetMapping(value={"categorias-restantes.json"})
	//@PreAuthorize("TODO")
	public List<SubcategoryPrimerNivel> categoriesRestantes() {
		Gson gson = new Gson();
		List<DataCategory> listaCategorias = dataCategoryService.categoriesRestantes();
		List<SubcategoryPrimerNivel> top5Categorias = new ArrayList<>();
		for(DataCategory dataCategory: listaCategorias) {
			SubcategoryPrimerNivel subcategoryPrimerNivel = gson.fromJson(dataCategory.getDatosJson(), SubcategoryPrimerNivel.class);
			top5Categorias.add(subcategoryPrimerNivel);
		}
		return top5Categorias;
	}
	
	
	@ApiOperation("Copones vigenes")
	@GetMapping(value={"cupones-vigentes.json"})
	//@PreAuthorize("TODO")
	public List<DataCoupon> cuponesVigentes() {
		return  dataCouponService.cuponesVigentes();
	}
	
	

}
