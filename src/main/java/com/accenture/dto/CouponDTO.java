package com.accenture.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonPropertyOrder({ "id", "image", "description", "seller", "expiresAt" })
@JsonInclude(value = Include.NON_DEFAULT, content = Include.NON_EMPTY)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Data
public class CouponDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2420579670364020440L;
	private String id;
	private String image;
	private String description;
	private String seller;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiresAt;
}
