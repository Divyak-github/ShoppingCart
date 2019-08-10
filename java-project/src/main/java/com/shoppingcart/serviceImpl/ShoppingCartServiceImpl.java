package com.shoppingcart.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import com.pojo.BasketItem;
import com.pojo.Category;
import com.pojo.Item;
import com.shoppingcart.service.ShoppingCartService;
import com.shoppingcart.util.ShoppingCartUtility;

/**
 * @author divya
 *
 */
public class ShoppingCartServiceImpl implements ShoppingCartService {

	// Member Variables
	private int totalCost = 0;
	private int totalRating = 0;
	private List<Category> categories = new ArrayList<Category>();
	private List<String> pickedCategories = new ArrayList<String>();
	private List<BasketItem> pickedItems = new ArrayList<BasketItem>();

	private ShoppingCartServiceImpl() {super();}
	private static class SingletonClassHolder {
        static final ShoppingCartServiceImpl SINGLE_INSTANCE = new ShoppingCartServiceImpl();
    }
    public static ShoppingCartServiceImpl getInstance() {
        return SingletonClassHolder.SINGLE_INSTANCE;
    }
	public void startShopping(int noOfCategories, int noOfItems, int minPrice, int maxPrice, int minShipCost,
			int maxShipCost, int minRating, int maxRating) {
		try {
			if (noOfCategories > 0 && noOfItems > 0) {
				loadCategories(noOfCategories, noOfItems, minPrice, maxPrice, minShipCost, maxShipCost, minRating,
						maxRating);
				if (this.categories != null) {
					pickAndAddToBasket(this.categories, maxRating);
					this.calculateTotalCostAndRating(pickedItems, null);
					printBasket(pickedItems);
				}

			}
		} catch (Exception e) {
			System.out.println("Shopping was interrupted due to Runtime Exceptions");
		}
	}

	/**
	 * @param categoryName
	 * @param noOfItems
	 * @param minPrice
	 * @param maxPrice
	 * @param minShipCost
	 * @param maxShipCost
	 * @param minRating
	 * @param maxRating
	 * @return
	 */
	public void loadCategories(int noOfCategories, int noOfItems, int minPrice, int maxPrice, int minShipCost,
			int maxShipCost, int minRating, int maxRating) {
		for (int i = 0; i < noOfCategories; i++) {
			String categoryName = "Category_" + (i + 1);
			categories.add(new Category(categoryName, loadItemsForCategory(categoryName, noOfItems, minPrice, maxPrice,
					minShipCost, maxShipCost, minRating, maxRating)));
		}
	}

	/**
	 * @param categoryName
	 * @param noOfItems
	 * @param minPrice
	 * @param maxPrice
	 * @param minShipCost
	 * @param maxShipCost
	 * @param minRating
	 * @param maxRating
	 * @return
	 */
	private List<Item> loadItemsForCategory(String categoryName, int noOfItems, int minPrice, int maxPrice,
			int minShipCost, int maxShipCost, int minRating, int maxRating) {
		List<Item> itemsForCategory = new ArrayList<Item>();
		int index = categoryName.indexOf("_");
		for (int i = 0; i < noOfItems; i++) {
			String itemName = "Item_" + (i + 1);
			itemsForCategory.add(new Item(ShoppingCartUtility.getRandomNumberInRange(minPrice, maxPrice),
					ShoppingCartUtility.getRandomNumberInRange(minShipCost, maxShipCost),
					ShoppingCartUtility.getRandomNumberInRange(minRating, maxRating),
					"Cat" + categoryName.substring(index + 1) + "_" + itemName));
			;
		}
		return itemsForCategory;
	}

	/*
	 * Get most optimal object from each category and start picking from those Until
	 * you reach 50 Optimal rating is closest to maxRating
	 */
	/**
	 * @param loadedCategories
	 * @param maxRating
	 * @return
	 */
	public void pickAndAddToBasket(List<Category> loadedCategories, int maxRating) throws Exception {
		List<Item> localPickedItems = new ArrayList<Item>();
		if(loadedCategories != null)
		{
			try 
			{
				for (Category cat : loadedCategories) 
				{
					Item optimizedItem = ShoppingCartUtility.getOptimizedItemForCategory(cat.getItems());
					if (optimizedItem != null) 
					{
						this.calculateTotalCostAndRating(pickedItems, optimizedItem);
						localPickedItems.add(new Item(
								optimizedItem.getPrice(), optimizedItem.getShippingCost(),
								optimizedItem.getRating(), optimizedItem.getItemName()));
					}
				}
				while (this.totalCost < 50) {
					Item optimizedItem = ShoppingCartUtility.getOptimizedItemForCategory(localPickedItems);
					this.calculateTotalCostAndRating(this.pickedItems, optimizedItem);
					if (this.totalCost < 50) {
						int maxIndex = optimizedItem.getItemName().indexOf("Item_");
						this.pickedItems.add(new BasketItem(
								"Category_" + optimizedItem.getItemName().substring(3, maxIndex - 1), optimizedItem));
						localPickedItems.remove(optimizedItem);
					}
				}
	
			} 
			catch (Exception e) 
			{
				throw new Exception("Picking Items Incomplete:");
			}
		}
	}

	/**
	 * @param pickedBasketItems
	 * @param item
	 * @return totalCost
	 * total cost Cost of item = Price + ShippingCost totalCost returns
	 *         total of all costs
	 *
	 */
	public void calculateTotalCostAndRating(List<BasketItem> pickedBasketItems, Item item) {
		this.totalCost = 0;
		this.totalRating = 0;
		try {
			if (null != pickedBasketItems && !pickedBasketItems.isEmpty() && pickedBasketItems.size() > 0) {
				pickedBasketItems.forEach((x) -> {
					this.totalCost += (x.getPickedItem().getPrice() + x.getPickedItem().getShippingCost());
					this.totalRating += x.getPickedItem().getRating();
				});
			}
			if (item != null)
				this.totalCost += item.getPrice() + item.getShippingCost();
		} catch (Exception e) {
			this.totalCost = 0;
			this.totalRating = 0;
		}
	}

	/**
	 * @param basketItems
	 * Prints Final Output
	 */
	public void printBasket(List<BasketItem> basketItems) {
		if (null != basketItems) {
			System.out
					.println("\n\n************************ Printing Basket Items Begins: *******************************");
			basketItems.forEach(x -> {
				System.out.println(x.getPickedCategoryName() + " : " + x.getPickedItem().getItemName() + " { Price = "
						+ x.getPickedItem().getPrice() + ", ShippingCost = " + x.getPickedItem().getShippingCost()
						+ ", Rating = " + x.getPickedItem().getRating() + " },");
			});
			System.out.println("\nTotal Cost = " + this.totalCost);
			System.out.println("Sum of Ratings = " + this.totalRating);
			System.out.println("\n\n************************ Printing Basket Items Complete: ****************************");
		}
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public List<BasketItem> getPickedItems() {
		return pickedItems;
	}

	public void setPickedItems(List<BasketItem> pickedItems) {
		this.pickedItems = pickedItems;
	}

	public List<String> getPickedCategories() {
		return pickedCategories;
	}

	public void setPickedCategories(List<String> pickedCategories) {
		this.pickedCategories = pickedCategories;
	}

}
