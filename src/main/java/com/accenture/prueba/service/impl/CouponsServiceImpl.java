package com.accenture.prueba.service.impl;

import com.accenture.prueba.client.CouponsClient;
import com.accenture.prueba.dto.CouponsResponseDto;
import com.accenture.prueba.dto.api.CouponApiResponse;
import com.accenture.prueba.service.CouponsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see CouponsService
 */
@Service
@RequiredArgsConstructor
public class CouponsServiceImpl implements CouponsService {

    /**
     * Bean de cliente de api de cupones
     */
    private final CouponsClient couponsClient;

    /**
     * @see CouponsService#get(boolean)
     */
    @Override
    public CouponsResponseDto get(boolean onlyNotExpired) {
        List<CouponsResponseDto.CouponDto> couponsList = couponsClient.getAll()
                .stream()
                .filter(coupon -> !onlyNotExpired || coupon.getExpiresAt().isAfter(LocalDate.now()))
                .map(this::mapper)
                .collect(Collectors.toList());


        return CouponsResponseDto.builder()
                .coupons(couponsList)
                .build();
    }

    /**
     * Metodo mapper para mapear respuesta de API a objeto de dominio
     * @param target Objeto de API
     * @return Objeto de dominio
     */
    private CouponsResponseDto.CouponDto mapper(CouponApiResponse target) {
        return CouponsResponseDto.CouponDto.builder()
                .id(target.getId())
                .descripcion(target.getDescription())
                .fechaExpiracion(target.getExpiresAt())
                .imagenURI(target.getImage())
                .vendedor(target.getSeller())
                .build();
    }

}
