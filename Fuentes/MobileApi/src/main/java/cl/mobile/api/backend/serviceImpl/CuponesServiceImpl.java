package cl.mobile.api.backend.serviceImpl;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import com.google.gson.reflect.TypeToken;

import cl.mobile.api.backend.apiClient.ApiClient;
import cl.mobile.api.backend.from.CuponesApi;
import cl.mobile.api.backend.service.CuponesService;
import cl.mobile.api.backend.to.Cupon;
import cl.mobile.api.backend.to.CuponesResponseRest;


/**
 * Implementación de lógica de llamada al api rest y/o caché de cupones, ordenamiento
 */
@Service
public class CuponesServiceImpl implements CuponesService {

	@Autowired
	private ApiClient apiClient;
	private static final Logger log = LoggerFactory.getLogger(CuponesServiceImpl.class);
	private static final String DATE_PATTERN = "yyyy-MM-dd";


	/**
	 * Método retorna cupones vigentes
	 */
	@Override
	public ResponseEntity<CuponesResponseRest> obtieneCuponesVigentes() {
		
		Date now = new Date();

		CuponesResponseRest response = new CuponesResponseRest();
		String resultado = apiClient.obtieneCupones();
		
		final Gson gson = new Gson();
		try {
			
			Type cuponesListType = new TypeToken<ArrayList<CuponesApi>>() {
			}.getType();
			List<CuponesApi> cuponesList = gson.fromJson(resultado, cuponesListType);
			response.getCuponesResponse().setCupones(obtieneCuponesVigentes(cuponesList));
			response.setMetadata("Respuesta Ok", "0", "Respuesta exitosa");			
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar servicio cupones");
			log.error("Error al consultar:" + e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<CuponesResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.setMetadata("Respuesta ok", "0", "Respuesta exitosa");
		Date after = new Date();
		long diff = after.getTime()-now.getTime();
		System.out.println("diff:"+diff+"[ms]");
		log.info("diff:"+diff+"[ms]");
		return new ResponseEntity<CuponesResponseRest>(response, HttpStatus.OK);
	}

	/** Búsqueda vigentes y conversión de objetos para respuesta api */
	private List<Cupon> obtieneCuponesVigentes(List<CuponesApi> cuponesList) {

		List<Cupon> data = new ArrayList<Cupon>();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

		List<CuponesApi> vigentes = toList(cuponesList
				.stream().filter(cupon -> Period
						.between(LocalDate.parse(cupon.getExpiresAt(), formatter), LocalDate.now()).getDays() <= 0).iterator());

		for (CuponesApi cupon : vigentes) {

			Cupon cup = new Cupon();
			cup.setDescription(cupon.getDescription());
			cup.setId(cupon.getId());
			cup.setSeller(cupon.getSeller());
			data.add(cup);
		}
		return data;
	}

	private List<CuponesApi> toList(Iterator<CuponesApi> it) {
		List<CuponesApi> list = new ArrayList<CuponesApi>();
		
		while(it.hasNext()) 
		{
			list.add(it.next());
		}
		
		return list;
	}

}
