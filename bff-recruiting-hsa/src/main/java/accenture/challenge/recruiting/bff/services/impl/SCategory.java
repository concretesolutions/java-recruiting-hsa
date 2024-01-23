package accenture.challenge.recruiting.bff.services.impl;

import accenture.challenge.recruiting.bff.clients.CategoryClient;
import accenture.challenge.recruiting.bff.domains.CategoryThree;
import accenture.challenge.recruiting.bff.dtos.CategoryDto;
import accenture.challenge.recruiting.bff.exceptions.GenericException;
import accenture.challenge.recruiting.bff.services.ICategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class SCategory implements ICategory {

    private static final Function<CategoryThree, List<CategoryDto>> buildCategories = categoryThree ->
            categoryThree.getSubcategories().get(0).getSubcategories().stream()
                    .map(category -> CategoryDto.builder()
                            .id(category.getId())
                            .name(category.getName())
                            .relevance(category.getRelevance())
                            .iconImageUrl(category.getIconImageUrl())
                            .build())
                    .collect(Collectors.toList());


    private final CategoryClient categoryClient;

    /**
     * Obtiene categorias.
     * @return 'CategoryThree'
     */
    private CategoryThree getCategoriesOrderRelevanceTop5() {
        log.info("INICIO - getCategoriesOrderRelevanceTop5");
        var categories = categoryClient.getCategoriesOrderReelevanceAndLimit(5);
        log.info("FIN - getCategoriesOrderRelevanceTop5 () -> " + categories);
        return categories;
    }

    /**
     * - Obtiene categorias
     * - Ordena de manera natural por reelevancia
     * - Limita tamaño de arreglo 5
     *
     * @return 'CategoryThree con las categorias ordenadas por reelevancia'
     */
    @Override
    public List<CategoryDto> getCategoriesOrderRelevanceAsc() {
        log.info("INICIO - getCategoriesOrderRelevanceAsc");
        try {
            var categories = getCategoriesOrderRelevanceTop5();
            var response = buildCategories.apply(categories);
            log.info("FIN - getCategoriesOrderRelevanceAsc () -> " + response);
            return response;
        } catch(Exception ex) {
            log.error("ERROR - getCategoriesOrderRelevanceAsc () -> " + ex.getMessage());
            throw new GenericException("Error al obtener categorias", ex);
        }
    }

}