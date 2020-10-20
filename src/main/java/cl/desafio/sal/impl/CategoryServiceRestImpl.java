package cl.desafio.sal.impl;

import cl.desafio.sal.CategoryServiceRest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by yasna.bastias.pina on 19-10-2020.
 */
@Service
public class CategoryServiceRestImpl implements CategoryServiceRest {

    private RestTemplate restTemplate;

    @Override
    public String getCategories(){
        return restTemplate();
    }

    private String restTemplate() {
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String endpoint = "https://cs-hsa-api-categories.herokuapp.com/categories";
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>( headers);
        ResponseEntity <String> result = restTemplate.exchange(endpoint, HttpMethod.GET, entity, String.class);
        return result.getBody();
    }
}
