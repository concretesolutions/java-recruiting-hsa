package com.accenture.concrete.domain;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Status implements Serializable {

	private static final long serialVersionUID = 5571586146759662777L;

	String code;

	String description;

}
