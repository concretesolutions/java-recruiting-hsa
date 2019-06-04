package com.desafio;

import com.Utils.CallApiUtils;
import com.desafio.entidades.CategorieThree;
import com.desafio.entidades.Cupon;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

@Repository
public class CategorieRepositorieImpl implements CategorieRepositorie {

    static final String API_CATEGORIE = "https://cs-hsa-api-categories.herokuapp.com/categories";
    private CallApiUtils apiUtils;

    @Autowired
    public CategorieRepositorieImpl() {
        this.apiUtils = new CallApiUtils();
    }

    @SuppressWarnings("static-access")
	public CategorieThree getListCategorie() throws IOException {
        CategorieThree categorieThree = new CategorieThree();

        ObjectMapper mapper = new ObjectMapper();

        CategorieThree data = new Gson().fromJson(this.apiUtils.getContentApi(API_CATEGORIE), CategorieThree.class);	
//        categorieThree = mapper.readValue(this.apiUtils.getContentApi(API_CATEGORIE), new TypeReference<CategorieThree>() {
//        });

        return data;
    }
}
