package com.concrete.desafio.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonUtils {

  public static <T> T jsonParser(
      final ObjectMapper objectMapper, final String json, final TypeReference<T> type)
      throws IOException {

    return objectMapper.readValue(json, type);
  }

  public static String jsonToString(final String fileName) throws IOException {
    final Class parser = JsonUtils.class;
    InputStream inputStream = parser.getResourceAsStream(String.format("/jsons/%s", fileName));

    return readFromInputStream(inputStream);
  }

  private static String readFromInputStream(InputStream inputStream) throws IOException {
    StringBuilder resultStringBuilder = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = br.readLine()) != null) {
        resultStringBuilder.append(line).append("\n");
      }
    }
    return resultStringBuilder.toString();
  }
}
