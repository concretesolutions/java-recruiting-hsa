package cl.accenture.bff.categoriescoupons.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
 * Copyright (c) 2023 Boris Molina
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    @JsonProperty(value = "code")
    private int code;
    @JsonProperty(value = "status")
    private String status;
    @JsonProperty(value = "message")
    private String message;
    @JsonProperty(value = "details")
    private String details;

}
