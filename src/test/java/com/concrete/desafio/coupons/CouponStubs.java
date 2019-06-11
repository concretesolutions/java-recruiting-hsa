package com.concrete.desafio.coupons;

import com.concrete.desafio.coupons.api.Coupon;
import com.concrete.desafio.utils.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import static com.concrete.desafio.utils.JsonUtils.jsonToString;

public class CouponStubs {

  public static ResponseEntity<List<Coupon>> expectedApiResponse() throws IOException {
    return new ResponseEntity<>(
        JsonUtils.jsonParser(
            new ObjectMapper(),
            jsonToString("coupons_api_response.json"),
            new TypeReference<List<Coupon>>() {}),
        HttpStatus.OK);
  }

  public static List<Coupon> expectedResponse() throws IOException {
    return JsonUtils.jsonParser(
        new ObjectMapper(),
        jsonToString("expected_coupons.json"),
        new TypeReference<List<Coupon>>() {});
  }
}
