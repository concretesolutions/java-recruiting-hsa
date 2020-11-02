package com.example.javarecruitinghsa.repository;

import com.example.javarecruitinghsa.pojo.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

@Service
public class CategoriaRepository {

    @Autowired
    RestTemplateBuilder builder;

    public Categoria findCategorias() {
        String url = "https://cs-hsa-api-categories.herokuapp.com/categories";
        return builder.build().getForEntity(url, Categoria.class).getBody();
    }
}
