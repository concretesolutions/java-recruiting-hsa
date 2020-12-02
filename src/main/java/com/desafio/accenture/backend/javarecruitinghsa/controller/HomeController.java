package com.desafio.accenture.backend.javarecruitinghsa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping("/")
    public String index() {
        return "Bienvenido al Desafio Accenture Java Backend Desarrollado por Alvaro Montilla";
    }

}
