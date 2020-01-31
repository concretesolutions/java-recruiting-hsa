package cl.accenture.concrete;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MimeTypeUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConcreteApplication.class)
@AutoConfigureMockMvc
class ConcreteApplicationTests {

	
	
	@Autowired
    private MockMvc mvc;

    @Test
    public void getValidsCoupons() throws Exception {
        mvc.perform(get("/concrete/coupons/valids"))
            .andExpect(status().isOk());
    }
   
    @Test
    public void getRemaining() throws Exception {
        mvc.perform(get("/categories/remaining").accept(MimeTypeUtils.APPLICATION_JSON_VALUE));
    }
  
    @Test
    public void getTopFive() throws Exception {
        mvc.perform(get("/categories/top-five").accept(MimeTypeUtils.APPLICATION_JSON_VALUE));
    }

}
