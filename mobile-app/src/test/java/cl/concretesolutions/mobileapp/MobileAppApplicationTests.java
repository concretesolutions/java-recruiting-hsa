package cl.concretesolutions.mobileapp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class MobileAppApplicationTests {

	@Autowired
	private MockMvc mock;
	
	private URL baseUrl;
	
	@BeforeEach
	public void setup() throws Exception {
		this.baseUrl = new URL("http://localhost:8080");
	}
	
	@Test
	void getCategories() throws Exception {
		mock.perform(MockMvcRequestBuilders.get(this.baseUrl.toString() + "/categories").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	void getCategoriesTree() throws Exception {
		mock.perform(MockMvcRequestBuilders.get(this.baseUrl.toString() + "/categories/tree").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	void getTopNCategories() throws Exception {
		mock.perform(MockMvcRequestBuilders.get(this.baseUrl.toString() + "/categories/top/3").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	
	@Test
	void getCoupons() throws Exception {
		mock.perform(MockMvcRequestBuilders.get(this.baseUrl.toString() + "/coupons").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

}
