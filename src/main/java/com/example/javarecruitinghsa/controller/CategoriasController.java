package com.example.javarecruitinghsa.controller;

import com.example.javarecruitinghsa.dto.CategoriaDTO;
import com.example.javarecruitinghsa.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriasController {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value = "/categorias/top", method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> top() {
        Optional<List<CategoriaDTO>> top = categoriaService.top();
        if (top.isPresent()) return ResponseEntity.of(top);
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @RequestMapping(value = "/categorias/restantes", method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> restantes() {
        Optional<List<CategoriaDTO>> top = categoriaService.restantes();
        if (top.isPresent()) return ResponseEntity.of(top);
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
