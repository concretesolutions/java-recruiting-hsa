package com.concrete.challenge.controllers.mobile;

import com.concrete.challenge.bean.categories.structure.Category;
import com.concrete.challenge.controllers.base.BaseController;
import com.concrete.challenge.service.CategoriesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "Categories API", description = "Categories API")
@RequestMapping("/mobile/categories")
public class MobileCategoriesController implements BaseController {

    @Autowired
    private CategoriesService categoriesService;

    @ApiOperation(value = "View a list of top categories", response = Category.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved category list"),
            @ApiResponse(code = 201, message = "Successfully retrieved empty category list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/top/{relevantCategories}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> getTopCategories(@PathVariable(value = "relevantCategories") int relevantCategories) {
        List<Category> categories = categoriesService.getMobileTopCategories(relevantCategories);
        return new ResponseEntity<>(categories, getResponseHeaders(), !categories.isEmpty() ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "View a list of categories past the top ones", response = Category.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved category list"),
            @ApiResponse(code = 201, message = "Successfully retrieved empty category list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/after/{relevantCategories}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> getCategoriesAfterTop(@PathVariable(value = "relevantCategories") int relevantCategories) {
        List<Category> categories = categoriesService.getMobileTopCategoriesAfterTop(relevantCategories);
        return new ResponseEntity<>(categories, getResponseHeaders(), !categories.isEmpty() ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
}
