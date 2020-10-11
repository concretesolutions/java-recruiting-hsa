package com.desafio.java.concrete.backend.helpers;

import com.desafio.java.concrete.backend.domains.Coupons;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ObjectJsonHelper {

    public static String toJson(Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            if( null != obj) {
                log.info(obj.toString());
                return mapper.writeValueAsString(obj);
            }

            return "[]";
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
    public static <T> T fromJson(String jsonStr, Class<T> cls)
            throws JsonParseException, JsonMappingException, IOException {
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(jsonStr,
                cls);
    }

    public static String successMessage(String message) {
        Map<String, Object> response = new HashMap<String, Object>();

        response.put("success", Boolean.valueOf(true));
        response.put("message", message);

        return toJson(response);
    }
    public static List<Coupons> getCouponsList(String jsonStr){
        Gson gson = new Gson();
        Type listaCupon = new TypeToken<List<Coupons>>(){}.getType();
        return gson.fromJson(jsonStr,listaCupon);
    }
}
