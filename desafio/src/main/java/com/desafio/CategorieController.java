package com.desafio;

import com.desafio.entidades.CategorieThree;
import com.desafio.entidades.Cupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategorieController {

    private CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @ResponseBody
    @RequestMapping(
            value = "/getCategorieTop5",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET
    )
    public CategorieThree categorieTop5() {
        return categorieService.getCategorieTop5();
    }

    @ResponseBody
    @RequestMapping(
            value = "/getCategorieOthers",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET
    )
    public CategorieThree categorieOther() {
        return categorieService.getCategorieOthers();
    }
}
