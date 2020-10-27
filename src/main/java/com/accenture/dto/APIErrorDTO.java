package com.accenture.dto;

import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class APIErrorDTO {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Builder.Default
	private Date timestamp = Calendar.getInstance().getTime();
	private Integer status;
	private String message;
	private String detail;

}
