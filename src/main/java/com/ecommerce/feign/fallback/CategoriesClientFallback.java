package com.ecommerce.feign.fallback;


import org.springframework.stereotype.Component;

import com.ecommerce.dto.CategoriesDto;
import com.ecommerce.feign.CategoriesClient;
import com.ecommerce.utils.ConstantesUtils;

@Component
public class CategoriesClientFallback implements CategoriesClient {

	@Override
	public CategoriesDto getAll() {
		throw new RuntimeException(ConstantesUtils.ERROR_CONEXION_API_CATEGORIAS);
	}
	

}
