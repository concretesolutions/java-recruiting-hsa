package com.concrete.desafio.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO implements Serializable {
  private String code;
  private String message;

  public ErrorDTO(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ErrorDTO errorDTO = (ErrorDTO) o;
    return Objects.equals(getCode(), errorDTO.getCode())
        && Objects.equals(getMessage(), errorDTO.getMessage());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCode(), getMessage());
  }
}
