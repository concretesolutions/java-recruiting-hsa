package com.mobile.orquestador.mobile.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XmlRootElement
public class MessageDto<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private transient T object;
	private BaseExceptionDto status;

}
