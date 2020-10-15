package cl.concretesolutions.mobileapp.api.category;

public class CategoryDto implements Comparable<CategoryDto> {
	/**
	 * Category Id
	 */
	private String id;

	/**
	 * Category Name
	 */
	private String name;

	/**
	 * Category Relevance
	 */
	private int relevance;

	/**
	 * Category Icon Image
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
	 * Category isTop
	 */
	private boolean isTop;

	/**
	 * Constructor
	 */
	public CategoryDto() {

	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param name
	 *            the name to set
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
	 * @param relevance
	 *            the relevance to set
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
	 * @param iconImageUrl
	 *            the iconImageUrl to set
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
	 * @param smallImageUrl
	 *            the smallImageUrl to set
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
	 * @param parentCategory
	 *            the parentCategory to set
	 */
	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}

	/**
	 * @return the isTop true if is the N of top categories, false if not
	 */
	public boolean isTop() {
		return isTop;
	}

	/**
	 * @param isTop
	 *            the isTop to set
	 */
	public void setTop(boolean isTop) {
		this.isTop = isTop;
	}

	@Override
	public int compareTo(CategoryDto categoryCompare) {
		int relevance = categoryCompare.getRelevance();
		return this.relevance - relevance;
	}

}
