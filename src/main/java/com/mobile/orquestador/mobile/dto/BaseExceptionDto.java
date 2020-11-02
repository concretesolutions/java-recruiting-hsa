package com.mobile.orquestador.mobile.dto;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@XmlRootElement
public class BaseExceptionDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String message;
	private String code;

}
