package com.example.servicioAPI.services;

import com.example.servicioAPI.base.ClienteHttp;
import com.example.servicioAPI.model.Category;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

@Service
public class CategoriasService {

    public Category consumirJSON(){
try {
    ClienteHttp cliente = new ClienteHttp();
    String respuesta = cliente.runRequestByGet("https://cs-hsa-api-categories.herokuapp.com/categories");
    JsonObject jsonObject = new JsonParser().parse(respuesta).getAsJsonObject();
    ObjectMapper mapper = new ObjectMapper();
    Category category = mapper.readValue(jsonObject.toString(), Category.class);
    return category;
        } catch (JsonMappingException e) {
            return null;
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
