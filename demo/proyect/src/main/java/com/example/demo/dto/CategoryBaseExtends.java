package com.example.demo.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;



@JsonPropertyOrder({ "id", "name", "relevance" })
@EqualsAndHashCode
@Data
public  class CategoryBaseExtends {
    private String id;
    private String name;
    private int relevance;
}

