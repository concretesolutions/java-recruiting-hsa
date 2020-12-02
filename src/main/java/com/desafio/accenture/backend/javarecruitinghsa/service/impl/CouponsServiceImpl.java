package com.desafio.accenture.backend.javarecruitinghsa.service.impl;

import com.desafio.accenture.backend.javarecruitinghsa.dto.CouponsDTO;
import com.desafio.accenture.backend.javarecruitinghsa.exception.GenericException;
import com.desafio.accenture.backend.javarecruitinghsa.feign.CouponsFeignClient;
import com.desafio.accenture.backend.javarecruitinghsa.service.CouponsService;
import com.desafio.accenture.backend.javarecruitinghsa.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CouponsServiceImpl implements CouponsService {

    @Autowired
    CouponsFeignClient couponsFeignClient;


    @Override
    public List<CouponsDTO> getCarruselCupones() throws GenericException {

        ResponseEntity<List<CouponsDTO>> couponsDTO = couponsFeignClient.getCoupons();

        List<CouponsDTO>  LstCoupons = Optional.ofNullable(couponsDTO)
                .filter(c -> c.getStatusCode().is2xxSuccessful())
                .map(co -> getCarruselCupons(co.getBody()))
                .orElseThrow(() -> new GenericException("Error al obtener las Categorias", 1));



        return LstCoupons;
    }

    private List<CouponsDTO> getCarruselCupons(List<CouponsDTO> coupons) {

        Date now = DateTimeUtil.getCurrentDateSystemTime();

       return coupons.stream()
               .filter(coupon ->  DateTimeUtil.stringToDate(coupon.getExpiresAt(), "yyyy-MM-dd").after(now))
               .collect(Collectors.toList());
    }




}
