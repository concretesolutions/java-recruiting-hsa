package cl.concretesolutions.mobileapp.api.category;

public class CategoryBase {
	
	/**
	 * Category Id
	 */
	private String id;
	
	/**
	 * Category name
	 */
	private String name;
	
	/**
	 * Category relevance
	 */
	private int relevance;
	
	/**
	 * Category iconImageUrl
	 */
	private String iconImageUrl;
	
	/**
	 * Category smallImageUrl
	 */
	private String smallImageUrl;
	
	/**
	 * Category parentCategory
	 */
	private String parentCategory;
	
	
	/**
	 * Constructor
	 */
	public CategoryBase () {
		
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the relevance
	 */
	public int getRelevance() {
		return relevance;
	}

	/**
	 * @param relevance the relevance to set
	 */
	public void setRelevance(int relevance) {
		this.relevance = relevance;
	}

	/**
	 * @return the iconImageUrl
	 */
	public String getIconImageUrl() {
		return iconImageUrl;
	}

	/**
	 * @param iconImageUrl the iconImageUrl to set
	 */
	public void setIconImageUrl(String iconImageUrl) {
		this.iconImageUrl = iconImageUrl;
	}

	/**
	 * @return the smallImageUrl
	 */
	public String getSmallImageUrl() {
		return smallImageUrl;
	}

	/**
	 * @param smallImageUrl the smallImageUrl to set
	 */
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}

	/**
	 * @return the parentCategory
	 */
	public String getParentCategory() {
		return parentCategory;
	}

	/**
	 * @param parentCategory the parentCategory to set
	 */
	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}
}
