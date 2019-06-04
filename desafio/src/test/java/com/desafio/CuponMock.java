package com.desafio;

import com.desafio.entidades.Cupon;

import java.util.ArrayList;
import java.util.List;

public class CuponMock {

    public static List<Cupon> withExpiredCupons() {

        List<Cupon> cupons = new ArrayList<Cupon>();
        cupons.add(new Cupon("","","","","2020-12-01"));
        cupons.add(new Cupon("","","","","2016-05-05"));
        cupons.add(new Cupon("","","","","2040-12-20"));

        return cupons;
    }

}
