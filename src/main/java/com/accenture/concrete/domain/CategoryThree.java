package com.accenture.concrete.domain;

import java.io.Serializable;
import java.util.List;

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
public class CategoryThree implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String name;

	int relevance;

	List<Categories> subcategories;

}
