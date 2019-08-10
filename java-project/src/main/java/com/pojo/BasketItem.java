package com.pojo;


public class BasketItem {

	private String pickedCategoryName ="";
	private Item pickedItem = new Item();
	
	public BasketItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BasketItem(String pickedCategoryName, Item picketItem) {
		super();
		this.pickedCategoryName = pickedCategoryName;
		this.pickedItem = picketItem;
	}

	public String getPickedCategoryName() {
		return pickedCategoryName;
	}

	public void setPickedCategoryName(String pickedCategoryName) {
		this.pickedCategoryName = pickedCategoryName;
	}

	public Item getPickedItem() {
		return pickedItem;
	}

	public void setPickedItem(Item picketItem) {
		this.pickedItem = picketItem;
	}

}
