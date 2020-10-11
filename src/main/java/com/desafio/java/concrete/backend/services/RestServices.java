package com.desafio.java.concrete.backend.services;

import com.desafio.java.concrete.backend.settings.ApiSettings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class RestServices {

    RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity responseEntity(String url){

        ResponseEntity restResponse = restTemplate.getForEntity(url,String.class);

        return restResponse;
    }

}
