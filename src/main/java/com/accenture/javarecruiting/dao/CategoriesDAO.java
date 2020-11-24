package com.accenture.javarecruiting.dao;

import com.accenture.javarecruiting.clients.CategoriesClient;
import com.accenture.javarecruiting.dto.CategoriesDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@RequiredArgsConstructor
public class CategoriesDAO {

    private final CategoriesClient categoriesClient;

    public List<CategoriesDTO> getCategories() throws JsonProcessingException {

        CategoriesDTO dataCategories = categoriesClient.CATEGORIES();
        ObjectMapper objectMapper = new ObjectMapper();
        String json1 = objectMapper.writeValueAsString(dataCategories);
        Object subcategories1 = JsonPath.read(json1, "$.subcategories[*]");
        Object subcategories2 = JsonPath.read(json1, "$.subcategories[*].subcategories[*]");
        Object subcategories3 = JsonPath.read(json1, "$.subcategories[*].subcategories[*].subcategories[*]");
        Object subcategories4 = JsonPath.read(json1, "$.subcategories[*].subcategories[*].subcategories[*].subcategories[*]");
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll((Collection<?>) subcategories1);
        jsonArray.addAll((Collection<?>) subcategories2);
        jsonArray.addAll((Collection<?>) subcategories3);
        jsonArray.addAll((Collection<?>) subcategories4);
        return jsonArray.stream()
                .map(s -> objectMapper.convertValue(s, CategoriesDTO.class))
                .peek(s -> s.setSubcategories(null))
                .collect(Collectors.toList());
    }

    public List<CategoriesDTO> getTopFiveCategories() throws JsonProcessingException {

        List<CategoriesDTO> totalCategories = this.getCategories();
        List<CategoriesDTO> categoriesSortedRelevance = totalCategories.stream()
                .filter(s -> s.getRelevance() != null)
                .sorted(Comparator.comparing(CategoriesDTO::getRelevance))
                .collect(Collectors.toList());

        int sizeCategories = categoriesSortedRelevance.size();
        List<CategoriesDTO> topFiveCategories;
        if (sizeCategories > 5) {
            topFiveCategories = categoriesSortedRelevance.subList(0, 5);
        } else {
            topFiveCategories = categoriesSortedRelevance.subList(0, sizeCategories);
        }
        return topFiveCategories;
    }

    public List<CategoriesDTO> getOthersCategories() throws JsonProcessingException {

        List<CategoriesDTO> totalCategories = this.getCategories();
        List<CategoriesDTO> categoriesSortedRelevance = totalCategories.stream()
                .filter(s -> s.getRelevance() != null)
                .sorted(Comparator.comparing(CategoriesDTO::getRelevance))
                .collect(Collectors.toList());
        List<CategoriesDTO> otherCategoriesNullRelevance = totalCategories.stream()
                .filter(s -> s.getRelevance() == null)
                .collect(Collectors.toList());
        int sizeCategories = categoriesSortedRelevance.size();
        List<CategoriesDTO> otherCategoriesWithRelevance;
        List<CategoriesDTO> otherCategories;
        if (sizeCategories > 5) {
            otherCategoriesWithRelevance = categoriesSortedRelevance.subList(5, sizeCategories);
            otherCategories = Stream.concat(otherCategoriesWithRelevance.stream(), otherCategoriesNullRelevance.stream()).collect(Collectors.toList());
        } else {
            otherCategories = otherCategoriesNullRelevance;
        }
        return otherCategories;
    }

}
