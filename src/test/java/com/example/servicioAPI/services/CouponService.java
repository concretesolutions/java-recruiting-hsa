package com.example.servicioAPI.services;

import com.example.servicioAPI.base.ClienteHttp;
import com.example.servicioAPI.model.Coupon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CouponService {

    public List<Coupon> consumirJSON(){
try {
    ClienteHttp cliente = new ClienteHttp();
    String respuesta = cliente.runRequestByGet("https://cs-hsa-api-coupons.herokuapp.com/coupons");
    JsonArray jsonList = new JsonParser().parse(respuesta).getAsJsonArray();
    ObjectMapper mapper = new ObjectMapper();
    List<Coupon> listCoupon = Arrays.asList(mapper.readValue(jsonList.toString(), Coupon[].class));
    return listCoupon;
        } catch (JsonMappingException e) {
            return null;
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
