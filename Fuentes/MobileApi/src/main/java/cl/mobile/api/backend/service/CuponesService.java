package cl.mobile.api.backend.service;

import org.springframework.http.ResponseEntity;

import cl.mobile.api.backend.to.CuponesResponseRest;

public interface CuponesService {
	
	public ResponseEntity<CuponesResponseRest> obtieneCuponesVigentes();	

}
