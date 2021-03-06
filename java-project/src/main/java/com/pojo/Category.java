package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private String categoryName = "";
	private List<Item> items = new ArrayList<Item>();

	public Category() {}

	public Category(String categoryName, List<Item> items) {
		super();
		this.categoryName = categoryName;
		this.items = items;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
