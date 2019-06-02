package com.aptiliux.dto.category;

import java.util.stream.Stream;

public interface Category {    
    String getId();
    String getName();
    Integer getRelevance();
    
    default Stream<Category> flattened(){
    	return Stream.of(this);
    }
}
