package com.example.javarecruitinghsa.service.impl;

import com.example.javarecruitinghsa.converter.CategoriaConverter;
import com.example.javarecruitinghsa.converter.CouponConverter;
import com.example.javarecruitinghsa.dto.CategoriaDTO;
import com.example.javarecruitinghsa.pojo.Coupon;
import com.example.javarecruitinghsa.repository.CategoriaRepository;
import com.example.javarecruitinghsa.repository.CouponRepository;
import com.example.javarecruitinghsa.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponRepository couponRepository;
    @Autowired
    CouponConverter couponConverter;

    @Override
    public Optional<List<Coupon>> aviable() {
        try {
            return Optional.ofNullable(couponConverter
                    .deleteExpired(couponRepository.findCouponList()));
        } catch (ParseException e) {
            return Optional.empty();
        }
    }
}
