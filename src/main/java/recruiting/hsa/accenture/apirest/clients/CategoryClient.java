package recruiting.hsa.accenture.apirest.clients;

import feign.RequestLine;

public interface CategoryClient {
	
	@RequestLine("GET /categories")
	public String getCategories();

}
