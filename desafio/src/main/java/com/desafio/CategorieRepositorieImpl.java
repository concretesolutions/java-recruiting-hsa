package com.desafio;

import com.Utils.CallApiUtils;
import com.desafio.entidades.CategorieThree;
import com.desafio.entidades.Cupon;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class CategorieRepositorieImpl implements CategorieRepositorie {

    static final String API_CATEGORIE = "https://cs-hsa-api-categories.herokuapp.com/categories";
    private CallApiUtils apiUtils;

    @Autowired
    public CategorieRepositorieImpl() {
        this.apiUtils = new CallApiUtils();
    }

    public List<CategorieThree> getListCategorie() throws IOException {
        List<CategorieThree> categorieThree = null;

        ObjectMapper mapper = new ObjectMapper();

        categorieThree = (List<CategorieThree>) mapper.readValue(this.apiUtils.getContentApi(API_CATEGORIE), new TypeReference<List<CategorieThree>>() {
        });

        return categorieThree;
    }
}
