package cl.mobile.api.backend.serviceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cl.mobile.api.backend.apiClient.ApiClient;
import cl.mobile.api.backend.from.CategoriesRootApi;
import cl.mobile.api.backend.service.CategoriaService;
import cl.mobile.api.backend.to.Categoria;
import cl.mobile.api.backend.to.CategoriaResponseRest;

/**
 * Implementación de lógica de llamada al api rest y/o caché, ordenamiento
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {

	private static final Logger log = LoggerFactory.getLogger(CategoriaServiceImpl.class);

	@Autowired
	private ApiClient apiClient;

	/**
	 * Método retorna resultado de búsqueda de categorias y aplica lógica para
	 * obtener top 5
	 */
	@Override
	public ResponseEntity<CategoriaResponseRest> obtieneCategoriasTop5() {

		CategoriaResponseRest response = new CategoriaResponseRest();
		Date now = new Date();
		String resultado = apiClient.obtieneCategorias();
		final Gson gson = new Gson();
		try {
			final CategoriesRootApi cate = gson.fromJson(resultado, CategoriesRootApi.class);
			response.getCategoriaResponse().setCategoria(obtieneTop5(cate));
			response.setMetadata("Respuesta Ok", "0", "Respuesta exitosa");

		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar categoria");
			log.error("Error al consultar:" + e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.setMetadata("Respuesta ok", "0", "Respuesta exitosa");
		Date after = new Date();
		long diff = after.getTime() - now.getTime();
		System.out.println("diff:" + diff + "[ms]");
		log.info("diff:" + diff + "[ms]");
		return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
	}

	/**
	 * Método retorna resultado de búsqueda de categorias y aplica lógica para
	 * obtener los no top 5
	 */
	@Override
	public ResponseEntity<CategoriaResponseRest> obtieneCategoriasNoTop5() {

		CategoriaResponseRest response = new CategoriaResponseRest();
		Date now = new Date();
		String resultado = apiClient.obtieneCategorias();
		final Gson gson = new Gson();
		try {

			final CategoriesRootApi cate = gson.fromJson(resultado, CategoriesRootApi.class);
			response.getCategoriaResponse().setCategoria(obtieneNoTop5(cate));
			response.setMetadata("Respuesta Ok", "0", "Respuesta exitosa");

		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar categoria");
			log.error("Error al consultar:" + e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Date after = new Date();
		long diff = after.getTime() - now.getTime();
		System.out.println("diff:" + diff + "[ms]");
		log.info("diff:" + diff + "[ms]");
		response.setMetadata("Respuesta ok", "0", "Respuesta exitosa");
		return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
	}

	private List<Categoria> obtieneTop5(CategoriesRootApi cate) {
		ArrayList<Categoria> lista = new ArrayList<Categoria>();

		CategoriesRootApi[] categories = cate.getSubcategories();
		if (categories != null && categories.length > 0 && "MOB".equals(categories[0].getId())) {
			for (CategoriesRootApi sub : categories[0].getSubcategories()) {
				lista.add(toCategoria(sub));
			}

		}


		List<Categoria> data = obtieneLista(lista.stream().sorted(Comparator.comparing(Categoria::getPeso).reversed()).limit(5).iterator());
		return data;
	}

	
	private List<Categoria> obtieneLista(Iterator<Categoria> iterator) {
		
		List<Categoria> list = new  ArrayList<Categoria>();
		
		
		while(iterator.hasNext()) 
		{
			list.add(iterator.next());
		}
		 
		return list;
	}

	private List<Categoria> obtieneNoTop5(CategoriesRootApi cate) {

		ArrayList<Categoria> lista = new ArrayList<Categoria>();

		CategoriesRootApi[] categories = cate.getSubcategories();
		if (categories != null && categories.length > 0 && "MOB".equals(categories[0].getId())) {
			for (CategoriesRootApi sub : categories[0].getSubcategories()) {
				lista.add(toCategoria(sub));
			}
		}

		List<Categoria> data = obtieneLista(lista.stream().sorted(Comparator.comparing(Categoria::getPeso).reversed()).iterator());
		List<Categoria> listaNo5 = new ArrayList<Categoria>();

		for (int i = 5; i < data.size(); i++) {
			listaNo5.add(data.get(i));
		}

		return listaNo5;
	}

	/** Conversión de objetos */
	private Categoria toCategoria(CategoriesRootApi sub) {
		Categoria cat = new Categoria();
		cat.setId(sub.getId());
		cat.setName(sub.getName());
		cat.setUrlImage(null);
		cat.setPeso(sub.getRelevance());
		cat.setUrlImage(obtieneUrl(sub));
		return cat;
	}

	/** Búsqueda de url imagen desde más pequeña : icono, small, medium, large*/
	private String obtieneUrl(CategoriesRootApi sub) {

		String url = obtieneUrlImagenString(sub);
		if (url != null)
			return url;

		for (CategoriesRootApi data : sub.getSubcategories()) {
			url = obtieneUrlImagenString(data);
			if (url != null) {
				break;
			}
		}
		return url;
	}

	private String obtieneUrlImagenString(CategoriesRootApi sub) {

		if (sub.getIconImageUrl() != null) {
			return sub.getIconImageUrl();
		}

		if (sub.getSmallImageUrl() != null) {
			return sub.getSmallImageUrl();
		}

		if (sub.getMediumImageUrl() != null) {
			return sub.getMediumImageUrl();
		}

		if (sub.getLargeImageUrl() != null) {
			return sub.getLargeImageUrl();
		}

		return null;
	}

}
