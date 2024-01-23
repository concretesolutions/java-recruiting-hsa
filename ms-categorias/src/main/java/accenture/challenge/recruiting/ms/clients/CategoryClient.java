package accenture.challenge.recruiting.ms.clients;

import accenture.challenge.recruiting.ms.domains.CategoryThree;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Category-Api-Client",
             url  = "${api.categorias.base}",
             path = "${api.categoria.path.obtener}")
public interface CategoryClient {

    @GetMapping()
    CategoryThree getCategoryThree();

}