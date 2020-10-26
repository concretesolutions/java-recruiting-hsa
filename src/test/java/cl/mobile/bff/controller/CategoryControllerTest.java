package cl.mobile.bff.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.mobile.bff.domain.CategoryClientResponse;
import cl.mobile.bff.service.interfaces.CategoryService;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {

	@MockBean
    private CategoryService categoryService;
	
	@BeforeEach
    public void setup() {
		CategoryClientResponse subcategory = new CategoryClientResponse();
		subcategory.setId("SUBCATEGORY1");
		subcategory.setName("SubCategory 1");
		subcategory.setRelevance(700);
		subcategory.setSmallImageUrl("URL");
		subcategory.setIconImageUrl("URL");
		
		CategoryClientResponse subcategory2 = new CategoryClientResponse();
		subcategory2.setId("SUBCATEGORY2");
		subcategory2.setName("SubCategory 2");
		subcategory2.setRelevance(200);
		subcategory2.setSmallImageUrl("URL");
		subcategory2.setIconImageUrl("URL");
		
		CategoryClientResponse subcategory3 = new CategoryClientResponse();
		subcategory3.setId("SUBCATEGORY3");
		subcategory3.setName("SubCategory 3");
		subcategory3.setRelevance(300);
		subcategory3.setSmallImageUrl("URL");
		subcategory3.setIconImageUrl("URL");
		
		CategoryClientResponse subcategory4 = new CategoryClientResponse();
		subcategory4.setId("SUBCATEGORY4");
		subcategory4.setName("SubCategory 4");
		subcategory4.setRelevance(400);
		subcategory4.setSmallImageUrl("URL");
		subcategory4.setIconImageUrl("URL");
		
		CategoryClientResponse subcategory5 = new CategoryClientResponse();
		subcategory5.setId("SUBCATEGORY5");
		subcategory5.setName("SubCategory 5");
		subcategory5.setRelevance(500);
		subcategory5.setSmallImageUrl("URL");
		subcategory5.setIconImageUrl("URL");
		
		CategoryClientResponse subcategory6 = new CategoryClientResponse();
		subcategory6.setId("SUBCATEGORY6");
		subcategory6.setName("SubCategory 6");
		subcategory6.setRelevance(600);
		subcategory6.setSmallImageUrl("URL");
		subcategory6.setIconImageUrl("URL");

		List<CategoryClientResponse> responseList = new ArrayList<>();
		
		responseList.add(subcategory6);
		responseList.add(subcategory5);
		responseList.add(subcategory4);
		responseList.add(subcategory3);
		responseList.add(subcategory2);
		
		Mockito.when(categoryService.getTopFive()).thenReturn(responseList);
		
		
		CategoryClientResponse subcategoryTest2 = new CategoryClientResponse();
		subcategoryTest2.setId("SUBCATEGORY1");
		subcategoryTest2.setName("SubCategory 1");
		subcategoryTest2.setRelevance(100);
		subcategoryTest2.setSmallImageUrl("URL");
		subcategoryTest2.setIconImageUrl("URL");
		
		CategoryClientResponse category1Test2 = new CategoryClientResponse();
		category1Test2.setId("CATEGORY1");
		category1Test2.setName("Category 1");
		category1Test2.setRelevance(0);
		category1Test2.setSmallImageUrl("URL");
		category1Test2.setIconImageUrl("URL");
		
		List<CategoryClientResponse> responseListTest2 = new ArrayList<>();
		
		responseListTest2.add(category1Test2);
		responseListTest2.add(subcategoryTest2);
		
		Mockito.when(categoryService.getRemain()).thenReturn(responseListTest2);
    }
	
    @Autowired
    private MockMvc mvc;
    
    @Test
    public void testGetTopFive() throws Exception {
    	CategoryClientResponse subcategory = new CategoryClientResponse();
		subcategory.setId("SUBCATEGORY1");
		subcategory.setName("SubCategory 1");
		subcategory.setRelevance(700);
		subcategory.setSmallImageUrl("URL");
		subcategory.setIconImageUrl("URL");
		
		CategoryClientResponse subcategory2 = new CategoryClientResponse();
		subcategory2.setId("SUBCATEGORY2");
		subcategory2.setName("SubCategory 2");
		subcategory2.setRelevance(200);
		subcategory2.setSmallImageUrl("URL");
		subcategory2.setIconImageUrl("URL");
		
		CategoryClientResponse subcategory3 = new CategoryClientResponse();
		subcategory3.setId("SUBCATEGORY3");
		subcategory3.setName("SubCategory 3");
		subcategory3.setRelevance(300);
		subcategory3.setSmallImageUrl("URL");
		subcategory3.setIconImageUrl("URL");
		
		CategoryClientResponse subcategory4 = new CategoryClientResponse();
		subcategory4.setId("SUBCATEGORY4");
		subcategory4.setName("SubCategory 4");
		subcategory4.setRelevance(400);
		subcategory4.setSmallImageUrl("URL");
		subcategory4.setIconImageUrl("URL");
		
		CategoryClientResponse subcategory5 = new CategoryClientResponse();
		subcategory5.setId("SUBCATEGORY5");
		subcategory5.setName("SubCategory 5");
		subcategory5.setRelevance(500);
		subcategory5.setSmallImageUrl("URL");
		subcategory5.setIconImageUrl("URL");
		
		CategoryClientResponse subcategory6 = new CategoryClientResponse();
		subcategory6.setId("SUBCATEGORY6");
		subcategory6.setName("SubCategory 6");
		subcategory6.setRelevance(600);
		subcategory6.setSmallImageUrl("URL");
		subcategory6.setIconImageUrl("URL");

		List<CategoryClientResponse> responseList = new ArrayList<>();
		
		responseList.add(subcategory6);
		responseList.add(subcategory5);
		responseList.add(subcategory4);
		responseList.add(subcategory3);
		responseList.add(subcategory2);
		
		ObjectMapper mapper = new ObjectMapper();
    	String responseListStr = mapper.writeValueAsString(responseList);
    	
    	mvc.perform(MockMvcRequestBuilders.get("/bff/mobile/api/category/topfive")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo(responseListStr)));
    }
    
    @Test
    public void testGetRemain() throws Exception {
    	CategoryClientResponse subcategory = new CategoryClientResponse();
		subcategory.setId("SUBCATEGORY1");
		subcategory.setName("SubCategory 1");
		subcategory.setRelevance(100);
		subcategory.setSmallImageUrl("URL");
		subcategory.setIconImageUrl("URL");
		
		CategoryClientResponse category1 = new CategoryClientResponse();
		category1.setId("CATEGORY1");
		category1.setName("Category 1");
		category1.setRelevance(0);
		category1.setSmallImageUrl("URL");
		category1.setIconImageUrl("URL");
		
		List<CategoryClientResponse> responseList = new ArrayList<>();
		
		responseList.add(category1);
		responseList.add(subcategory);
		
		ObjectMapper mapper = new ObjectMapper();
    	String responseListStr = mapper.writeValueAsString(responseList);
    	
    	mvc.perform(MockMvcRequestBuilders.get("/bff/mobile/api/category/remain")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo(responseListStr)));
    }
}
