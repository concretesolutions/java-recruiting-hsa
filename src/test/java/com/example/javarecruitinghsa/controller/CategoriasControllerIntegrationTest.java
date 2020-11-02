package com.example.javarecruitinghsa.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoriasControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnData_top() throws Exception {
        this.mockMvc
                .perform(get("/categorias/top"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Nintendo")));
    }

    @Test
    public void shouldReturnData_restantes() throws Exception {
        this.mockMvc
                .perform(get("/categorias/restantes"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Travel")));
    }
}
