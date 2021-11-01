package com.proyecto.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.proyecto.dto.Coupon;
import com.proyecto.service.ICuponService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

@Service
@Scope("singleton")
public class CuponServiceImpl implements ICuponService {

	@Value("${servicio.url.cupones}")
	private String urlServicio;
	
	private Date fechaUltimoLlamado;
	private List<Coupon> lista;

	public CuponServiceImpl() {
		this.fechaUltimoLlamado = new Date();
		this.lista = new ArrayList<>();
	}
	
	@Override
	public void llamarServicio() {

		Client client = Client.create();
		WebResource webresource = client.resource(urlServicio);

		List<Coupon> resultado = webresource.type(MediaType.APPLICATION_JSON).get(new GenericType<List<Coupon>>() {});

		// Obtiene solo cupones que no han expirado
		this.lista = resultado.stream().filter(x -> x.getExpiresAt().after(new Date())).collect(Collectors.toList());
	}
	
	@Override
	public List<Coupon> obtener() {
		
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
		
		if (lista.isEmpty() || !s.format(fechaUltimoLlamado).equals(s.format(new Date())))  // Si se carga por primera vez, u hoy es un nuevo dia
			llamarServicio();
		
		return this.lista;
	}

}



























