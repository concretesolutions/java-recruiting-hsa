package com.example.servicioAPI.services;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;


@Component
public class CallRestService implements CommandLineRunner {
    CategoriasService categoriasService = new CategoriasService();
    CouponService couponService = new CouponService();

    public void callRestService() throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
    }
        @Override
    public void run(String... args) throws Exception {
     callRestService();
    }
}
