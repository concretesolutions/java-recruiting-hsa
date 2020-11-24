package com.accenture.javarecruiting;

import com.accenture.javarecruiting.dto.CategoriesDTO;
import com.accenture.javarecruiting.dto.CouponsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JavaRecruitingApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Valid Coupons Test")
    public void validCouponsTest() throws Exception {
        JSONArray responseCoupons = this.responseClient("/coupons/valid");
        ObjectMapper mapper = new ObjectMapper();
        List<CouponsDTO> coupons = responseCoupons.stream()
                .map(s -> mapper.convertValue(s, CouponsDTO.class))
                .collect(Collectors.toList());
        assertNotNull(coupons);
        assertEquals(3, coupons.size());
    }

    @Test
    @DisplayName("Not Valid Coupons Test")
    public void notValidCouponsTest() throws Exception {
        JSONArray responseCoupons = this.responseClient("/coupons/valid");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ObjectMapper mapper = new ObjectMapper();
        Date currentDate = new Date();
        List<CouponsDTO> couponsNotValid = responseCoupons.stream()
                .map(s -> mapper.convertValue(s, CouponsDTO.class))
                .filter(data -> {
                    Date parseExpiresAt = null;
                    try {
                        parseExpiresAt = sdf.parse(data.getExpiresAt());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return Objects.requireNonNull(parseExpiresAt).before(currentDate);
                })
                .collect(Collectors.toList());
        assertNotNull(responseCoupons);
        assertEquals(0, couponsNotValid.size());
    }

    @Test
    @DisplayName("Top Five Categories Test")
    public void topFiveCategoriesTest() throws Exception {
        JSONArray responseCategories = this.responseClient("/categories/top5");
        ObjectMapper mapper = new ObjectMapper();
        List<CategoriesDTO> categories = responseCategories.stream()
                .map(s -> mapper.convertValue(s, CategoriesDTO.class))
                .collect(Collectors.toList());
        assertNotNull(categories);
        assertEquals(5, categories.size());
    }

    @Test
    @DisplayName("Others Categories Test")
    public void othersCategoriesTest() throws Exception {
        JSONArray responseCategories = this.responseClient("/categories/others");
        ObjectMapper mapper = new ObjectMapper();
        List<CategoriesDTO> categories = responseCategories.stream()
                .map(s -> mapper.convertValue(s, CategoriesDTO.class))
                .collect(Collectors.toList());
        assertNotNull(categories);
        assertEquals(12, categories.size());
    }

    public JSONArray responseClient(String urlTemplate) throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get(urlTemplate)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String responseString = response.getResponse().getContentAsString();
        Object jsonRead = JsonPath.read(responseString, "$");
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll((Collection<?>) jsonRead);
        return jsonArray;
    }

}
