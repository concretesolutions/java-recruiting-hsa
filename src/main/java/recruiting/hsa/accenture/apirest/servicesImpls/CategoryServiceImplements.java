package recruiting.hsa.accenture.apirest.servicesImpls;

import org.springframework.stereotype.Service;

import feign.Feign;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import recruiting.hsa.accenture.apirest.clients.CategoryClient;

@Service
public class CategoryServiceImplements implements CategoryClient {

	@Override
	public String getCategories() {
		CategoryClient category = Feign.builder()
				  .client(new OkHttpClient())
				  .logger(new Slf4jLogger(CategoryClient.class))
				  .target(CategoryClient.class, "https://cs-hsa-api-categories-rest.herokuapp.com/");
		return category.getCategories();
	}

}
