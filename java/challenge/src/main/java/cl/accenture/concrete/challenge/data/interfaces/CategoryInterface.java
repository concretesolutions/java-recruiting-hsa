package cl.accenture.concrete.challenge.data.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.accenture.concrete.challenge.model.Category;

@FeignClient(value = "${categories.api.src.ws.name}", url="${categories.api.src.ws.endpoint}")
public interface CategoryInterface {
	
	@RequestMapping(method = RequestMethod.GET, 
			value = "${categories.api.src.ws.get.path}", 
			produces = "application/json")
	Category getCategoyTree();
	
}
