package com.concrete.desafio.categories;

import com.concrete.desafio.categories.api.CategoryThree;
import com.concrete.desafio.utils.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import static com.concrete.desafio.utils.JsonUtils.jsonToString;

public class CategoryStubs {

  public static ResponseEntity<CategoryThree> expectedApiResponse() throws IOException {
    return new ResponseEntity<>(
        JsonUtils.jsonParser(
            new ObjectMapper(),
            jsonToString("categories_complete.json"),
            new TypeReference<CategoryThree>() {}),
        HttpStatus.OK);
  }

  public static List<CategoryResponse> expectedTopFiveOutput() throws IOException {
    return JsonUtils.jsonParser(
        new ObjectMapper(),
        jsonToString("expected_response.json"),
        new TypeReference<List<CategoryResponse>>() {});
  }

  public static List<CategoryResponse> expectedRemainingOutput() throws IOException {
    return JsonUtils.jsonParser(
        new ObjectMapper(),
        jsonToString("expected_remaining_categories.json"),
        new TypeReference<List<CategoryResponse>>() {});
  }

  public static ResponseEntity<CategoryThree> subCategoryNullOutput() throws IOException {
    return new ResponseEntity<>(
        JsonUtils.jsonParser(
            new ObjectMapper(),
            jsonToString("categories_null.json"),
            new TypeReference<CategoryThree>() {}),
        HttpStatus.OK);
  }

  public static ResponseEntity<CategoryThree> subCategoryMobileMarketNotFound() throws IOException {
    return new ResponseEntity<>(
        JsonUtils.jsonParser(
            new ObjectMapper(),
            jsonToString("subcategories_null.json"),
            new TypeReference<CategoryThree>() {}),
        HttpStatus.OK);
  }

  public static ResponseEntity<CategoryThree> categoryWithOnlyFourSubcategories()
      throws IOException {
    return new ResponseEntity<>(
        JsonUtils.jsonParser(
            new ObjectMapper(),
            jsonToString("only_four_subcategories.json"),
            new TypeReference<CategoryThree>() {}),
        HttpStatus.OK);
  }
}
