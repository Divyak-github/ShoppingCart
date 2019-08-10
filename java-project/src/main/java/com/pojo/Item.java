package com.pojo;

public class Item {

	private int price;
	private int shippingCost;
	private int rating;
	private int cost;
	private String itemName = "";

	public Item() {}

	public Item(int price, int shippingCost, int rating, String itemName) {
		super();
		this.price = price;
		this.shippingCost = shippingCost;
		this.rating = rating;
		this.itemName = itemName;
		this.cost = this.price + this.shippingCost;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(int shippingCost) {
		this.shippingCost = shippingCost;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
