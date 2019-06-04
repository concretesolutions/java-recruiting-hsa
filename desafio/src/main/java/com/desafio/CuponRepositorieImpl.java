package com.desafio;

import com.Utils.CallApiUtils;
import com.desafio.entidades.Cupon;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import jdk.nashorn.internal.codegen.CompilerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class CuponRepositorieImpl implements CuponRepositorie {

    static final String API_CUPON = "https://cs-hsa-api-coupons.herokuapp.com/coupons";
    private CallApiUtils apiUtils;

    @Autowired
    public CuponRepositorieImpl() {
        this.apiUtils = new CallApiUtils();
    }

    public List<Cupon> getListCupon() throws IOException {
        List<Cupon> cupones = null;

        ObjectMapper mapper = new ObjectMapper();

        cupones = (List<Cupon>) mapper.readValue(this.apiUtils.getContentApi(API_CUPON), new TypeReference<List<Cupon>>() {
        });

        return cupones;
    }
}
