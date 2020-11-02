package com.concrete.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coupon {
    private String id;
    private String description;
    private String seller;
    private String image;
    private String expiresAt;

    public boolean valid() {
        boolean answer =true;
        try{
            LocalDate expiredDate = LocalDate.parse(expiresAt);
            LocalDate currentDay = LocalDate.now();
            answer = expiredDate.isAfter(currentDay) || expiredDate.isEqual(currentDay);
        }catch (DateTimeParseException | NullPointerException ex){
            answer = false;
        }
        return answer;
    }
}
