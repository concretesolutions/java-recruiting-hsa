package com.desafio.sha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.sha.domain.ResponseCategories;
import com.desafio.sha.service.CategoriasService;

@RestController
public class CategoriasController {
	@Autowired
	CategoriasService categoriasService;
	
	@GetMapping(value = "/categorias/top-five", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ResponseCategories>> getTopFiveCategorias()
	{
		return new ResponseEntity<>(categoriasService.getTopFive(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/categorias/remaining", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ResponseCategories>> getRemaingCategorias()
	{
		return new ResponseEntity<>(categoriasService.getRemaining(), HttpStatus.OK);
	}
}
