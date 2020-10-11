package com.desafio.java.concrete.backend.services;


import com.desafio.java.concrete.backend.domains.Catalog;
import com.desafio.java.concrete.backend.domains.CatalogTable;
import com.desafio.java.concrete.backend.domains.TopFiveCatalog;
import com.desafio.java.concrete.backend.helpers.ObjectJsonHelper;
import com.desafio.java.concrete.backend.helpers.constants.Constant;
import com.desafio.java.concrete.backend.settings.ApiSettings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoriesServices {

    @Autowired
    ApiSettings apiSettings;

    @Autowired
    RestServices restServices;

    public String getCategories() {
        String topCategories = "";
        try {
            ResponseEntity catalogo = restServices.responseEntity(apiSettings.getCategoriaURL());
            if (catalogo.getStatusCodeValue()== Constant.HTTP_OK) {
                Catalog catalog = ObjectJsonHelper.fromJson(catalogo.getBody().toString(), Catalog.class);
                topCategories = ObjectJsonHelper.toJson(getCatalog(catalog.getSubcategories().get(0).getSubcategories()));
            } else {
                topCategories = String.format("%s%n%s%n%s", catalogo.getStatusCode(), catalogo.getStatusCodeValue(), catalogo.getBody());
                log.error("Error: {}",topCategories, catalogo.getBody());
            }
        } catch (IOException e) {
            log.error("Error: {}", e.getMessage());
        }
        return topCategories;
    }

    public String getTopCategories() {
        String topCategories = "";

        try {
            ResponseEntity catalogo = restServices.responseEntity(apiSettings.getCategoriaURL());
            if (catalogo.getStatusCodeValue()== Constant.HTTP_OK) {

                Catalog catalog = ObjectJsonHelper.fromJson(catalogo.getBody().toString(), Catalog.class);
                log.info(catalog.toString());

                topCategories = ObjectJsonHelper.toJson(getTopFive(catalog.getSubcategories().get(0).getSubcategories()));

                log.info("Respuesta :{}", topCategories);

            } else {
                topCategories = String.format("%s%n%s%n%s", catalogo.getStatusCode(), catalogo.getStatusCodeValue(), catalogo.getBody());
                log.error("Error: {}", String.format("%s%n%s%n%s", catalogo.getStatusCode(), catalogo.getStatusCodeValue(), catalogo.getBody()));
            }

        } catch (IOException e) {
            log.error("Error: {}", e.getMessage());
        }

        return topCategories;
    }

    private Map<Integer, Catalog> orderedCategory(List<Catalog> subCategories) {
        Map<Integer, Catalog> categories = new LinkedHashMap<>();
        Iterator iCategories = subCategories.iterator();
        while (iCategories.hasNext()) {
            Catalog catalog1 = (Catalog) iCategories.next();
            categories.put(catalog1.getRelevance(), catalog1);
        }
        return categories;
    }

    private List<TopFiveCatalog> getTopFive(List<Catalog> subCategories) {
        Map<Integer, Catalog> categories = orderedCategory(subCategories);
        List<TopFiveCatalog> topFive = categories.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Catalog>comparingByKey().reversed())
                .limit(5)
                .map(c -> {
                    TopFiveCatalog tf = TopFiveCatalog.builder()
                            .relevance(c.getKey())
                            .name(c.getValue().getName())
                            .iconImageUrl(c.getValue().getMediumImageUrl())
                            .build();
                    return tf;
                })
                .collect(Collectors.toList());
        log.info(topFive.toString());
        return topFive;
    }

    private List<CatalogTable> getCatalog(List<Catalog> subCategories) {
        Map<Integer, Catalog> categories = orderedCategory(subCategories);
        return categories.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Catalog>comparingByKey().reversed())
                .skip(5)
                .map(c -> {
                    return CatalogTable.builder()
                            .id(c.getValue().getId())
                            .name(c.getValue().getName())
                            .relevance(c.getValue().getRelevance())
                            .smallImageUrl(c.getValue().getSmallImageUrl())
                            .subcategories(c.getValue().getSubcategories())
                            .build();


                })
                .collect(Collectors.toList());
    }


}
