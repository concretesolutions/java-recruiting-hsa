package com.Utils;

import jdk.nashorn.internal.codegen.CompilerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CallApiUtils {

    static RestTemplate restTemplate;

    @Autowired
    public CallApiUtils() {

    }

    public static String getContentApi(String urlApi) {

        if (restTemplate == null)
            restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(urlApi, String.class);

        return result;
    }
}
