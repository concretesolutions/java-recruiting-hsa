package cl.mobile.api.backend.from;
/**
 * Data del origen (parse) del json
 * Correspondiente a respuesta de api categorias
 * */
public class CategoriesRootApi {
	
	private String id;
	private String name;
	private int relevance;
	private String largeImageUrl;
	private String mediumImageUrl;
	private String smallImageUrl;
	private String iconImageUrl;
	private CategoriesRootApi[] subcategories;
	
	public CategoriesRootApi[] getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(CategoriesRootApi[] subcategories) {
		this.subcategories = subcategories;
	}
	public int getRelevance() {
		return relevance;
	}
	public void setRelevance(int relevance) {
		this.relevance = relevance;
	}
	public String getLargeImageUrl() {
		return largeImageUrl;
	}
	public void setLargeImageUrl(String largeImageUrl) {
		this.largeImageUrl = largeImageUrl;
	}
	public String getMediumImageUrl() {
		return mediumImageUrl;
	}
	public void setMediumImageUrl(String mediumImageUrl) {
		this.mediumImageUrl = mediumImageUrl;
	}
	public String getSmallImageUrl() {
		return smallImageUrl;
	}
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
	public String getIconImageUrl() {
		return iconImageUrl;
	}
	public void setIconImageUrl(String iconImageUrl) {
		this.iconImageUrl = iconImageUrl;
	}
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

}
