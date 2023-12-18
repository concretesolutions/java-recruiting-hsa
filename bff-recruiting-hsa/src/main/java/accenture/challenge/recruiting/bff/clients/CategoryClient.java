package accenture.challenge.recruiting.bff.clients;

import accenture.challenge.recruiting.bff.domains.CategoryThree;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "Category-MS-Client",
             url  = "http://localhost:8080",
             path = "/challenge/categories")
public interface CategoryClient {

    @GetMapping
    CategoryThree getCategoriesOrderReelevanceAndLimit(@RequestParam("cantidad") Integer cantidad);

}