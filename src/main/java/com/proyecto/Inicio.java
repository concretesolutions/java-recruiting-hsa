package com.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proyecto.service.ICuponService;

@SpringBootApplication
public class Inicio implements CommandLineRunner 
{
	@Autowired
	ICuponService servicio;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(Inicio.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		servicio.obtener().forEach(x -> System.out.println(x.toString()));
	}
}
