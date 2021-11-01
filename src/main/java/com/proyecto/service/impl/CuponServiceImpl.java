package com.proyecto.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.proyecto.dto.Coupon;
import com.proyecto.service.ICuponService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

@Service
public class CuponServiceImpl implements ICuponService {

	@Value("${servicio.url.cupones}")
	private String urlServicio;
	
	@Override
	public List<Coupon> obtener() {
		
		List<Coupon> lista = new ArrayList<>();
		
		try {	
			Client client = Client.create();
			WebResource webresource = client.resource(urlServicio);
			
			lista = webresource
					.type(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<Coupon>>(){});
				
			return lista.stream().filter(x -> x.getExpiresAt().after(new Date())).collect(Collectors.toList());  // Obtiene solo cupones que no han expirado
		} 
		catch (Exception ex) {
			return lista; 
		}
	}

}
