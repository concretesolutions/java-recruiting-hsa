package com.proyecto;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.proyecto.service.ICuponService;
import com.proyecto.service.impl.CuponServiceImpl;

@SpringBootApplication
public class Inicio
{
	private static final Logger log = LoggerFactory.getLogger(Inicio.class);
	
	public static void main(String[] args) throws InterruptedException, ExecutionException 
	{
		log.info("Inicio Aplicación");
		
		CompletableFuture<String> cargarCupones = CompletableFuture.supplyAsync(() -> {
			
		    ApplicationContext contexto = SpringApplication.run(Inicio.class, args);
			ICuponService servicioCupon = contexto.getBean(CuponServiceImpl.class);
			servicioCupon.llamarServicio();
			
		    return "Carga de cupones terminada";
		});
		
		log.info(cargarCupones.get());
	}
}



















