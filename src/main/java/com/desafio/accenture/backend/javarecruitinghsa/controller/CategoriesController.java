package com.desafio.accenture.backend.javarecruitinghsa.controller;

import com.desafio.accenture.backend.javarecruitinghsa.constant.Contansts;
import com.desafio.accenture.backend.javarecruitinghsa.dto.CouponsDTO;
import com.desafio.accenture.backend.javarecruitinghsa.dto.ProductsSubCategoryDTO;
import com.desafio.accenture.backend.javarecruitinghsa.dto.response.GenericResponse;
import com.desafio.accenture.backend.javarecruitinghsa.exception.GenericException;
import com.desafio.accenture.backend.javarecruitinghsa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/top-categories", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<GenericResponse> getTopCategories() {
        GenericResponse response = new GenericResponse();
        try {
            List<ProductsSubCategoryDTO> categoryDTOList = categoryService.getAllCategoriesTopFive();

            response.setCodResponse(Contansts.CODIGO_RESPUESTA_CORRECTA);
            response.setMessage("OK");
            response.setResult(categoryDTOList);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (GenericException e) {
            response.setCodResponse(Contansts.CODIGO_RESPUESTA_INCORRECTA);
            response.setMessage(e.getMessage());
            response.setResult(null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/getCategories", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<GenericResponse> getCategories() {
        GenericResponse response = new GenericResponse();

        try {
            List<ProductsSubCategoryDTO> categoryDTOList = categoryService.getRestCategoriesExceptTopFive();
            response.setCodResponse(Contansts.CODIGO_RESPUESTA_CORRECTA);
            response.setMessage("OK");
            response.setResult(categoryDTOList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (GenericException e) {
            response.setCodResponse(Contansts.CODIGO_RESPUESTA_INCORRECTA);
            response.setMessage(e.getMessage());
            response.setResult(null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
