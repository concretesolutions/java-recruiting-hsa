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
public class SubCategoriaN4 implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String name;

	int relevance;

}
