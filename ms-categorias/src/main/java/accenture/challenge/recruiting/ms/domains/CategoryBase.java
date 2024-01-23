package accenture.challenge.recruiting.ms.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Setter
@Getter
@ToString
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class CategoryBase implements Serializable {

    private String id;
    private String name;
    private Integer relevance;
    private String iconImageUrl;
    private String largeImageUrl;
    private String mediumImageUrl;
    private String smallImageUrl;

}