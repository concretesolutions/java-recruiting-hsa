package ServiceConsumer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class that represents a category
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
    private String id;
    private String name;
    private int relevance;
    private String iconImageUrl;
    private String smallImageUrl;
    private Category[] subcategories;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    public String getIconImageUrl() {
        return iconImageUrl;
    }

    public void setIconImageUrl(String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public Category[] getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Category[] subcategories) {
        this.subcategories = subcategories;
    }
}
