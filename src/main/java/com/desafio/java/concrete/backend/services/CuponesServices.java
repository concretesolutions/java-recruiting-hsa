package com.desafio.java.concrete.backend.services;

import com.desafio.java.concrete.backend.domains.CarruselNotExpired;
import com.desafio.java.concrete.backend.domains.Catalog;
import com.desafio.java.concrete.backend.domains.Coupons;
import com.desafio.java.concrete.backend.helpers.DateHelper;
import com.desafio.java.concrete.backend.helpers.ObjectJsonHelper;
import com.desafio.java.concrete.backend.helpers.constants.Constant;
import com.desafio.java.concrete.backend.settings.ApiSettings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CuponesServices {
    @Autowired
    ApiSettings apiSettings;

    @Autowired
    RestServices restServices;

    public String getCarruselCupones() {

        ResponseEntity cupon = restServices.responseEntity(apiSettings.getCuponURL());
        if (cupon.getStatusCodeValue()== Constant.HTTP_OK){
            List<Coupons> coupons = ObjectJsonHelper.getCouponsList(cupon.getBody().toString());

            List<CarruselNotExpired> notExpireds = coupons.stream()
                    .filter(c -> c.getExpiresAt().after(DateHelper.getFechaActual()))
                    .map(c -> {
                        CarruselNotExpired notExpired = CarruselNotExpired.builder()
                                .expiresAt(c.getExpiresAt())
                                .iconImageUrl(c.getImage())
                                .name(c.getDescription())
                                .build();
                        return notExpired;
                    })
                    .collect(Collectors.toList());

            log.info(notExpireds.toString());
            return ObjectJsonHelper.toJson(notExpireds);
        }else{
            log.error("Error: {}",String.format("%s%n%s%n%s", cupon.getStatusCode(), cupon.getStatusCodeValue(), cupon.getBody()));
            return String.format("%s%n%s%n%s", cupon.getStatusCode(), cupon.getStatusCodeValue(), cupon.getBody());
        }

    }
}
