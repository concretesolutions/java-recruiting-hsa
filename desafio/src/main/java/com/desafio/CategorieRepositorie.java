package com.desafio;

import com.desafio.entidades.CategorieThree;
import com.desafio.entidades.Cupon;

import java.io.IOException;
import java.util.List;

public interface CategorieRepositorie {

    CategorieThree getListCategorie() throws IOException;
}
