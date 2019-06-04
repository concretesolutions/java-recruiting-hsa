package com.desafio;

import com.desafio.entidades.Cupon;

import java.io.IOException;
import java.util.List;

public interface CuponRepositorie {

    List<Cupon> getListCupon() throws IOException;
}
