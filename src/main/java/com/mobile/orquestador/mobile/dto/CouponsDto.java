package com.mobile.orquestador.mobile.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CouponsDto {

	private Date expiresAt;
	private String description;
	private String id;
	private String image;
	private String seller;

}
