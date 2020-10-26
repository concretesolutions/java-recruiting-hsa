package cl.mobile.bff.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cl.mobile.bff.client.interfaces.CategoryClient;
import cl.mobile.bff.domain.CategoryClientResponse;
import cl.mobile.bff.service.interfaces.CategoryService;

@SpringBootTest
public class CategoryServiceTest {

	@Mock
    private CategoryClient categoryClient;
	
	@InjectMocks
    private CategoryService categoryService = new CategoryServiceImpl();
	
	@BeforeEach
    void setMockOutput() {
		
		List<CategoryClientResponse> subcategories = new ArrayList<>();
		
		CategoryClientResponse subcategory = new CategoryClientResponse();
		subcategory.setId("SUBCATEGORY1");
		subcategory.setName("SubCategory 1");
		subcategory.setRelevance(100);
		subcategory.setSmallImageUrl("URL");
		subcategory.setIconImageUrl("URL");
		subcategories.add(subcategory);
		
		CategoryClientResponse subcategory2 = new CategoryClientResponse();
		subcategory2.setId("SUBCATEGORY2");
		subcategory2.setName("SubCategory 2");
		subcategory2.setRelevance(200);
		subcategory2.setSmallImageUrl("URL");
		subcategory2.setIconImageUrl("URL");
		subcategories.add(subcategory2);
		
		CategoryClientResponse subcategory3 = new CategoryClientResponse();
		subcategory3.setId("SUBCATEGORY3");
		subcategory3.setName("SubCategory 3");
		subcategory3.setRelevance(300);
		subcategory3.setSmallImageUrl("URL");
		subcategory3.setIconImageUrl("URL");
		subcategories.add(subcategory3);
		
		CategoryClientResponse subcategory4 = new CategoryClientResponse();
		subcategory4.setId("SUBCATEGORY4");
		subcategory4.setName("SubCategory 4");
		subcategory4.setRelevance(400);
		subcategory4.setSmallImageUrl("URL");
		subcategory4.setIconImageUrl("URL");
		subcategories.add(subcategory4);
		
		CategoryClientResponse subcategory5 = new CategoryClientResponse();
		subcategory5.setId("SUBCATEGORY5");
		subcategory5.setName("SubCategory 5");
		subcategory5.setRelevance(500);
		subcategory5.setSmallImageUrl("URL");
		subcategory5.setIconImageUrl("URL");
		subcategories.add(subcategory5);
		
		CategoryClientResponse subcategory6 = new CategoryClientResponse();
		subcategory6.setId("SUBCATEGORY6");
		subcategory6.setName("SubCategory 6");
		subcategory6.setRelevance(600);
		subcategory6.setSmallImageUrl("URL");
		subcategory6.setIconImageUrl("URL");
		subcategories.add(subcategory6);
		
		CategoryClientResponse categoryMock = new CategoryClientResponse();
		categoryMock.setId("CATEGORY1");
		categoryMock.setName("Category 1");
		categoryMock.setRelevance(0);
		categoryMock.setSmallImageUrl("URL");
		categoryMock.setIconImageUrl("URL");
		categoryMock.setSubcategories(subcategories);
		
		when(categoryClient.getCategories()).thenReturn(categoryMock);
	}
	
	@DisplayName("Test getTopFive method")
	@Test
    void testGetTopFive() throws JsonProcessingException {
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
		String serviceResponse = mapper.writeValueAsString(categoryService.getTopFive());
		
		assertEquals(responseListStr, serviceResponse);
    }
	
	@DisplayName("Test getRemain method")
	@Test
    void testGetRemain() throws JsonProcessingException {
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
		String serviceResponse = mapper.writeValueAsString(categoryService.getRemain());
		
		assertEquals(responseListStr, serviceResponse);
    }
}
