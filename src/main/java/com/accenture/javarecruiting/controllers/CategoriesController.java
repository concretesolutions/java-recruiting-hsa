package com.accenture.javarecruiting.controllers;

import com.accenture.javarecruiting.dao.CategoriesDAO;
import com.accenture.javarecruiting.dto.CategoriesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class CategoriesController {

    @Autowired
    private CategoriesDAO categoriesDAO;

    @GetMapping("/categories/top5")
    public List<CategoriesDTO> getTopFiveCategories() throws IOException {
        return categoriesDAO.getTopFiveCategories();
    }

    @GetMapping("/categories/others")
    public List<CategoriesDTO> getOthersCategories() throws IOException {
        return categoriesDAO.getOthersCategories();
    }
}
