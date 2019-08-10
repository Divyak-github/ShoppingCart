package com.shoppingcart.service;

import java.util.List;
import com.pojo.BasketItem;
import com.pojo.Category;
import com.pojo.Item;


public interface ShoppingCartService {

/**
 * @param noOfCategories
 * @param noOfItems
 */
public default void startShopping(int noOfCategories, int noOfItems){}

/**
 * @param noOfCategories
 * @param noOfItems
 * @param minPrice
 * @param maxPrice
 * @param minShipCost
 * @param maxShipCost
 * @param minRating
 * @param maxRating
 */
public default void loadCategories(int noOfCategories, int noOfItems, int minPrice, int maxPrice, int minShipCost,
		int maxShipCost, int minRating, int maxRating) {}

/**
 * @param loadedCategories
 * @param maxRating
 * @throws Exception
 */
public default void pickAndAddToBasket(List<Category> loadedCategories, int maxRating) throws Exception {}

/**
 * @param pickedBasketItems
 * @param item
 */
public default void calculateTotalCostAndRating(List<BasketItem> pickedBasketItems, Item item) {}

/**
 * @param basketItems
 */
public default void printBasket(List<BasketItem> basketItems) {}


}
