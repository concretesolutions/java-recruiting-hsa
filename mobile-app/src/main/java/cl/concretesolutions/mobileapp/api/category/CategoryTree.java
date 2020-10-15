package cl.concretesolutions.mobileapp.api.category;

import java.util.ArrayList;
import java.util.List;

public class CategoryTree extends CategoryBase {
	private List<CategoryTree> subcategories = new ArrayList<CategoryTree>();

	public List<CategoryTree> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<CategoryTree> subcategories) {
		this.subcategories = subcategories;
	}

}
