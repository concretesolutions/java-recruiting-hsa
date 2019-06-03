package com.desafio;

import com.desafio.entidades.CategorieThree;
import com.desafio.entidades.Cupon;

import java.util.List;

public interface CategorieService {

    List<CategorieThree> getCategorieTop5();

    List<CategorieThree> getCategorieOthers();
}
