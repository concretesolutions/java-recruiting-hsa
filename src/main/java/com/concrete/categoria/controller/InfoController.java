package com.concrete.categoria.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController {

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", "HOLA");
		return "welcome";
	}

	
}
