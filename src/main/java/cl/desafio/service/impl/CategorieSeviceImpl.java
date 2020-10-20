package cl.desafio.service.impl;

import cl.desafio.domain.CategoryResponse;
import cl.desafio.domain.Subcategory;
import cl.desafio.domain.SubcategoryLvl2;
import cl.desafio.sal.CategoryServiceRest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.desafio.service.CategoryService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yasna.bastias.pina on 19-10-2020.
 */
@Service
public class CategorieSeviceImpl implements CategoryService{

    static int NUM_TOP =5;

    @Autowired
    private CategoryServiceRest categoryServiceRest;

    @Override
    public CategoryResponse getTop5Categories(){

        ObjectMapper mapper = new ObjectMapper();
        CategoryResponse categoryResponse = new CategoryResponse();

        List<SubcategoryLvl2> subcategoryListLvl2;


        try {
            categoryResponse = mapper.readValue(categoryServiceRest.getCategories(),
                    new TypeReference<CategoryResponse>(){});

            categoryResponse.getSubcategories().stream()
                    .forEach(x -> x.setSubcategories(orden(x.getSubcategories())));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return categoryResponse;
    }

    private List<SubcategoryLvl2> orden (List<SubcategoryLvl2> lvl2List){
        List<SubcategoryLvl2> subcategoryLvl2s = new ArrayList<SubcategoryLvl2>();

        try {
            subcategoryLvl2s = lvl2List.stream().sorted(Comparator.comparingInt(SubcategoryLvl2::getRelevance)).
                    collect(Collectors.toList());
            subcategoryLvl2s = subcategoryLvl2s.stream().limit(NUM_TOP).collect(Collectors.toList());
        } catch (Exception e){
            e.printStackTrace();
        }
        return subcategoryLvl2s;
    }

    @Override
    public CategoryResponse getOtherCategories(){

        ObjectMapper mapper = new ObjectMapper();
        CategoryResponse listOthersCategory = new CategoryResponse();
        CategoryResponse othersCategoryResponse = new CategoryResponse();
        CategoryResponse topCategory = getTop5Categories();

        try {
            othersCategoryResponse = mapper.readValue(categoryServiceRest.getCategories(),
                    new TypeReference<CategoryResponse>(){});

            listOthersCategory = borrar(topCategory, othersCategoryResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOthersCategory;

    }

    private CategoryResponse borrar (CategoryResponse topCategory, CategoryResponse othersCategoryResponse){

        for(Subcategory subcategory : topCategory.getSubcategories())
        {
            for(SubcategoryLvl2 subcategoryLvl2 : subcategory.getSubcategories())
            {
                othersCategoryResponse.getSubcategories().stream().
                        forEach(x -> x.getSubcategories().removeIf(y-> y.getId().equals(subcategoryLvl2.getId())));
            }
        }
        return othersCategoryResponse;
    }


}
