package cl.accenture.bff.categoriescoupons.client;

import cl.accenture.bff.categoriescoupons.config.FeignConfig;
import cl.accenture.bff.categoriescoupons.dto.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Copyright (c) 2023 Boris Molina
 */
@FeignClient(name = "categoriesClient", url = "${external.services.categories.url}",
        configuration = FeignConfig.class)
public interface CategoriesClient {

    @GetMapping("/categories")
    Category getCategories();

}
