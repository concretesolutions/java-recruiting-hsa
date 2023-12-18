package accenture.challenge.recruiting.bff.controllers;

import accenture.challenge.recruiting.bff.dtos.CategoryDto;
import accenture.challenge.recruiting.bff.services.ICategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "BFF punto de acceso para cliente movile")
@RestController
@RequestMapping(value = "/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategory iCategory;

    @ApiOperation(
            value = "Obtiene categorias ordenadas por reelevancia",
            notes = "Obtiene categorias ordenadas por reelevancia",
            produces = "ResponseEntity<List<CategoryDto>>")
    @ApiResponses({
            @ApiResponse(code = 500, message = "Error General"),
            @ApiResponse(code = 200, message = "Obtiene resultado")
    })
    @GetMapping("/top-5")
    public ResponseEntity<List<CategoryDto>> getCategoriesOrderRelevance() {
        var categoriesOrderrelevance = iCategory.getCategoriesOrderRelevanceAsc();
        return ResponseEntity.ok(categoriesOrderrelevance);
    }

}