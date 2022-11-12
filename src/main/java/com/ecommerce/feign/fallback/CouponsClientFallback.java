package com.ecommerce.feign.fallback;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ecommerce.dto.CouponsDto;
import com.ecommerce.feign.CouponsClient;
import com.ecommerce.utils.ConstantesUtils;

@Component
public class CouponsClientFallback implements CouponsClient {
	public List<CouponsDto> getAll() {
		throw new RuntimeException(ConstantesUtils.ERROR_CONEXION_API_CUPONES);
	}

}
