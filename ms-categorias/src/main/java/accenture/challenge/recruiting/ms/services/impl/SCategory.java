package accenture.challenge.recruiting.ms.services.impl;

import accenture.challenge.recruiting.ms.clients.CategoryClient;
import accenture.challenge.recruiting.ms.domains.CategoryThree;
import accenture.challenge.recruiting.ms.exceptions.GenericException;
import accenture.challenge.recruiting.ms.services.ICategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNullElse;

@Log4j2
@Service
@RequiredArgsConstructor
public class SCategory implements ICategory {

    private static final Consumer<CategoryThree> orderCategoryByRelevanceAsc = categorythree ->
            categorythree.getSubcategories()
                    .forEach(category -> category.setSubcategories(
                            category.getSubcategories().stream()
                                    .filter(cate -> nonNull(cate.getRelevance()))
                                    .sorted(Comparator.comparing(CategoryThree.SubCategoryBase_2:: getRelevance))
                                    .collect(Collectors.toList())));

    private static final BiConsumer<CategoryThree, Integer> limitSizeList = (categorythree, cantidad) ->
            categorythree.getSubcategories()
                    .forEach(category -> category.setSubcategories(
                            category.getSubcategories().stream()
                                    .limit(requireNonNullElse(cantidad, category.getSubcategories().size()))
                                    .collect(Collectors.toList())));

    private final CategoryClient categoryClient;

    /**
     * Obtiene categorias.
     * @return 'CategoryThree'
     */
    private CategoryThree getCategoryThree() {
        log.info("INICIO - getCategoryThree");
        var categorythree = categoryClient.getCategoryThree();
        log.info("FIN - getCategoryThree () -> " + categorythree);
        return categorythree;
    }

    /**
     * - Obtiene categorias
     * - Ordena de manera natural por reelevancia
     * - Limita tamaño de arreglo segun cantidad solicitada
     *
     * @return 'CategoryThree con las categorias ordenadas por reelevancia'
     */
    @Override
    public CategoryThree getCategoriesOrderRelevanceAsc(Integer cantidad) {
        log.info("INICIO - getCategoriesOrderRelevanceAsc");
        try {
            var categorythree = getCategoryThree();
            orderCategoryByRelevanceAsc.accept(categorythree);
            limitSizeList.accept(categorythree, cantidad);
            log.info("FIN - getCategoriesOrderRelevanceAsc () -> " + categorythree);
            return categorythree;
        } catch(Exception ex) {
            log.error("ERROR - getCategoriesOrderRelevanceAsc () -> " + ex.getMessage());
            throw new GenericException("Error al obtener categorias", ex);
        }
    }

}