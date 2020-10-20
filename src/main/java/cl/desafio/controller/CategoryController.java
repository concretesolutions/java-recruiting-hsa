package cl.desafio.controller;

import cl.desafio.domain.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cl.desafio.service.CategoryService;

import java.util.List;

/**
 * Created by yasna.bastias.pina on 19-10-2020.
 */
@RequestMapping("/category")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categorieService;

    @RequestMapping(value = "/getTop5Categories", method = RequestMethod.GET)
    public CategoryResponse getTop5Categories() {

        return categorieService.getTop5Categories();
    }

    @RequestMapping(value = "/getOtherCategories", method = RequestMethod.GET)
    public CategoryResponse getOtherCategories() {

        return categorieService.getOtherCategories();
    }

}
