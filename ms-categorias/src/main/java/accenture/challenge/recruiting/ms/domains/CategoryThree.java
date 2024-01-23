package accenture.challenge.recruiting.ms.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Setter
@Getter
@ToString
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class CategoryThree extends CategoryBase implements Serializable {

    private List<SubCategoryBase_1> subcategories;

    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @JsonInclude(NON_NULL)
    public static class SubCategoryBase_1 extends CategoryBase implements Serializable {
        private List<SubCategoryBase_2> subcategories;
    }

    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @JsonInclude(NON_NULL)
    public static class SubCategoryBase_2 extends CategoryBase implements Serializable {
        private List<SubCategoryBase_3> subcategories;
    }

    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @JsonInclude(NON_NULL)
    public static class SubCategoryBase_3 extends CategoryBase implements Serializable {
        private List<CategoryBase> subcategories;
    }

}