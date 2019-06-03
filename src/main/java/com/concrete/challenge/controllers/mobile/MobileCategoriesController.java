package com.concrete.challenge.controllers.mobile;

import com.concrete.challenge.bean.categories.structure.Category;
import com.concrete.challenge.controllers.base.BaseController;
import com.concrete.challenge.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mobile/categories")
public class MobileCategoriesController implements BaseController {

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping(value = "/top/{relevantCategories}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> getTopCategories(@PathVariable(value = "relevantCategories") int relevantCategories) {
        List<Category> categories = categoriesService.getMobileTopCategories(relevantCategories);
        return new ResponseEntity<>(categories, getResponseHeaders(), !categories.isEmpty() ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/after/{relevantCategories}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> getCategoriesAfterTop(@PathVariable(value = "relevantCategories") int relevantCategories) {
        List<Category> categories = categoriesService.getMobileTopCategoriesAfterTop(relevantCategories);
        return new ResponseEntity<>(categories, getResponseHeaders(), !categories.isEmpty() ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
}
