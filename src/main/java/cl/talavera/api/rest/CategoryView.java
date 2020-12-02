package cl.talavera.api.rest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryView {
    private String name;
    private int relevance;
}
