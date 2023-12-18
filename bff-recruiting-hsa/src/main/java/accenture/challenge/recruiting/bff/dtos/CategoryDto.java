package accenture.challenge.recruiting.bff.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class CategoryDto {
    private String id;
    private String name;
    private Integer relevance;
    private String iconImageUrl;

    @JsonCreator
    public CategoryDto(
            @JsonProperty("subcategories[0].subcategories[0].id") String id,
            @JsonProperty("subcategories[0].subcategories[0].name") String name,
            @JsonProperty("subcategories[0].subcategories[0].relevance") Integer relevance,
            @JsonProperty("subcategories[0].subcategories[0].iconImageUrl") String iconImageUrl) {
        this.id = id;
        this.name = name;
        this.relevance = relevance;
        this.iconImageUrl = iconImageUrl;
    }

}