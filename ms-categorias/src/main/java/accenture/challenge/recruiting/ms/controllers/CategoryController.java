package accenture.challenge.recruiting.ms.controllers;

import accenture.challenge.recruiting.ms.domains.CategoryThree;
import accenture.challenge.recruiting.ms.services.ICategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Controlador encargado de las operacion de categorias")
@RestController
@RequestMapping(value = "/challenge/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategory iCategory;

    @ApiOperation(
            value = "Obtiene categorias ordenadas por reelevancia",
            notes = "Obtiene categorias ordenadas por reelevancia",
            produces = "ResponseEntity<CategoryThree>")
    @ApiResponses({
            @ApiResponse(code = 500, message = "Error General"),
            @ApiResponse(code = 200, message = "Obtiene resultado")
    })
    @GetMapping
    public ResponseEntity<CategoryThree> getCategoriesOrderRelevance(
            @RequestParam(required = false) Integer cantidad) {
        var categoriesOrderrelevance = iCategory.getCategoriesOrderRelevanceAsc(cantidad);
        return ResponseEntity.ok(categoriesOrderrelevance);
    }

}