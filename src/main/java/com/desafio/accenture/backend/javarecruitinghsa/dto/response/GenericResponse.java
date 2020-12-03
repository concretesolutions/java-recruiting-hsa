package com.desafio.accenture.backend.javarecruitinghsa.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse implements Serializable {
    private static final long serialVersionUID = -8334268935782633442L;


    @JsonProperty(value = "id")
    private Integer codResponse;


    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "result")
    private Object result;


}
