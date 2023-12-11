package cl.accenture.bff.categoriescoupons.exception;

import feign.FeignException;
import feign.Request;
import feign.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
 * Copyright (c) 2023 Boris Molina
 */
@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new TestController())
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Test
    public void testHandleFeignException() throws Exception {
        mockMvc.perform(get("/test"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message")
                        .value("[500 Feign error occurred] during [GET] to [] [Test Feign Exception]: []"))
                .andExpect(jsonPath("$.details")
                        .value("uri=/test"));
    }

    @EnableWebMvc
    @RestController
    public static class TestController {
        @GetMapping("/test")
        public void test() {
            throw FeignException.errorStatus("Test Feign Exception",
                    Response.builder()
                            .status(500)
                            .reason("Feign error occurred")
                            .request(Request.create(Request.HttpMethod.GET,
                                    "",
                                    Collections.emptyMap(),
                                    null,
                                    null,
                                    null))
                            .build());
        }
    }

}
