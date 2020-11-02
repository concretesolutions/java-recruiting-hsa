package com.example.javarecruitinghsa.converter;

import com.example.javarecruitinghsa.dto.CategoriaDTO;
import com.example.javarecruitinghsa.pojo.Categoria;
import com.example.javarecruitinghsa.pojo.Subcategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaConverter {

    public List<CategoriaDTO> convert(Categoria value) {
        List<CategoriaDTO> result = new ArrayList<>();
        List<Subcategory> subcategories = value.getSubcategories().get(0).getSubcategories();
        for (Subcategory category : subcategories) {
            CategoriaDTO categoriaDTO = new CategoriaDTO();
            if (category.getSubcategories().isEmpty()) {
                categoriaDTO.setCategoria(category.getName());
                categoriaDTO.setSubcategoria(category.getName());
                categoriaDTO.setNombre(category.getName());
                categoriaDTO.setRelevancia(category.getRelevance());
                categoriaDTO.setImageUrl(category.getIconImageUrl());
            } else {
                categoriaDTO.setCategoria(category.getName());
                category = category.getSubcategories().get(0);
                if (category.getSubcategories().isEmpty()) {
                    categoriaDTO.setSubcategoria(category.getName());
                    categoriaDTO.setNombre(category.getName());
                    categoriaDTO.setRelevancia(category.getRelevance());
                    categoriaDTO.setImageUrl(category.getSmallImageUrl());
                } else {
                    categoriaDTO.setSubcategoria(category.getName());
                    categoriaDTO.setImageUrl(category.getSmallImageUrl());
                    category = category.getSubcategories().get(0);
                    categoriaDTO.setNombre(category.getName());
                    categoriaDTO.setRelevancia(category.getRelevance());
                }
            }
            result.add(categoriaDTO);
        }
        return result;
    }
}
