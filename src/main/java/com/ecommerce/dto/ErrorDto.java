package com.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {

	private String code;
	private String message;
}
