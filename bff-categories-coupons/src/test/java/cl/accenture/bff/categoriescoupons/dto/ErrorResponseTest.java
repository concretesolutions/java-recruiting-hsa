package cl.accenture.bff.categoriescoupons.dto;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * Copyright (c) 2023 Boris Molina
 */
public class ErrorResponseTest {

    @Test
    public void testErrorResponse() {
        Date date = new Date();
        ErrorResponse subErrorResponse = new ErrorResponse();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(date)
                .code(1)
                .status("status")
                .message("message")
                .details("details")
                .build();

        assertThat(errorResponse.getTimestamp()).isEqualTo(date);
        assertThat(errorResponse.getCode()).isEqualTo(1);
        assertThat(errorResponse.getStatus()).isEqualTo("status");
        assertThat(errorResponse.getMessage()).isEqualTo("message");
        assertThat(errorResponse.getDetails()).isEqualTo("details");

        ErrorResponse anotherErrorResponse = ErrorResponse.builder()
                .timestamp(date)
                .code(1)
                .status("status")
                .message("message")
                .details("details")
                .build();

        assertThat(errorResponse).isEqualTo(anotherErrorResponse);
        assertThat(errorResponse.hashCode()).isEqualTo(anotherErrorResponse.hashCode());
        assertThat(errorResponse.toString()).isNotNull();
        assertThat(subErrorResponse).isNotNull();
    }

}
