package com.desafio;

import com.desafio.entidades.CategorieThree;
import com.desafio.entidades.Cupon;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class CategorieMock {

    public static CategorieThree withCategorieThree() {

        CategorieThree categorie = Mockito.mock(CategorieThree.class);

        return categorie;
    }

}
