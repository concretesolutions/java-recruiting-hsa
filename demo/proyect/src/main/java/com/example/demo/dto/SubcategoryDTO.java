package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;



@JsonPropertyOrder({ "id", "name", "relevance", "subcategories","iconImageUrl" })
@EqualsAndHashCode(callSuper = true)
@Data
public  class SubcategoryDTO  extends  CategoryBaseExtends{


    @JsonProperty("subcategories")
    private List<SubLastCategory> subcategories;
    private String iconImageUrl;

    @EqualsAndHashCode(callSuper = true)
    @JsonPropertyOrder({ "id", "name", "relevance", "subcategories","mediumImageUrl","mediumImageUrl","smallImageUrl" })
    @Data
    static class SubLastCategory extends  CategoryBaseExtends{

        @JsonProperty("subcategories")
        private List<CategoryBase> subcategories;

        private String largeImageUrl;
        private String mediumImageUrl;
        private String smallImageUrl;

    }
}
