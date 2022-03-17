package recruiting.hsa.accenture.apirest.pojos;

import org.json.JSONObject;

public class CategoryPojo {

	private String id;
	private String name;
	private Long relevance;
	private String smallImageUrl;

	public CategoryPojo() {
	}

	public CategoryPojo(JSONObject categoryPojo) {
		this.name = categoryPojo.getString("name");
		this.id = categoryPojo.getString("id");
		this.relevance = categoryPojo.optLong("relevance");
		this.smallImageUrl = categoryPojo.optString("smallImageUrl",null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getRelevance() {
		return relevance;
	}

	public void setRelevance(Long relevance) {
		this.relevance = relevance;
	}

	public String getSmallImageUrl() {
		return smallImageUrl;
	}

	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}

}
