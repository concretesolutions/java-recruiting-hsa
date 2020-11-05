package com.accenture.test.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Coupons {

	/** The id. */
	private String id;
	
	/** The description. */
	private String description;
	
	/** The seller. */
	private String seller;
	
	/** The image. */
	private String image;
	
	/** The expires at. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate expiresAt;
}
