package cl.accenture.concrete.challenge.model;

import java.util.List;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Category implements Comparable<Category> {
	
	//Common fields
	private String id;
	private String name;
	private int relevance;
	
	//Specific fields (can be null)
	@JsonInclude(Include.NON_NULL)
	private String iconImageUrl;
	@JsonInclude(Include.NON_NULL)
	private String largeImageUrl;
	@JsonInclude(Include.NON_NULL)
	private String mediumImageUrl;
	@JsonInclude(Include.NON_NULL)
	private String smallImageUrl;
	
	//Subcategories Tree
	@JsonInclude(Include.NON_EMPTY)
	private List<Category> subcategories;

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

	public List<Category> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<Category> subcategories) {
		this.subcategories = subcategories;
	}

	@Override
	public int compareTo(Category compareCat) {
		// TODO Auto-generated method stub
		return Integer.valueOf(this.getRelevance()) - Integer.valueOf(compareCat.getRelevance());
	}
	
	public Stream<Category> flatten(){
		if(this.getSubcategories() == null) return Stream.of(this);
		return Stream.concat(Stream.of(this), this.getSubcategories().stream().flatMap(Category::flatten));
	}

}
