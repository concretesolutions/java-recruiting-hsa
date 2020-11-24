package com.accenture.javarecruiting.dao;

import com.accenture.javarecruiting.clients.CouponsClient;
import com.accenture.javarecruiting.dto.CouponsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CouponsDAO {

    private final CouponsClient couponsClient;

    public List<CouponsDTO> getValidCoupons() {

        List<CouponsDTO> dataCoupons = couponsClient.getAll();
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return dataCoupons.stream().filter(data -> {
            Date parseExpiresAt = null;
            try {
                parseExpiresAt = sdf.parse(data.getExpiresAt());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return Objects.requireNonNull(parseExpiresAt).after(currentDate);
        }).collect(Collectors.toList());
    }

}
