package com.shoppingcart.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.pojo.Category;
import com.pojo.Item;

public class ShoppingCartUtility {
public ShoppingCartUtility() {
		}



	/*
 * Demonstrating Polymorphism
 */
	public static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		else if(min <0 || max <0)
			throw new IllegalArgumentException("Negatives not allowed:");

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	
	
	public static double getRandomNumberInRange(double min, double max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		else if(min <0 || max <0)
			throw new IllegalArgumentException("Negatives not allowed:");
		
		return Math.round(ThreadLocalRandom.current().nextDouble(min, max));
	}
	
	/*
	 * public static Map<Integer, String> getCostListforCategory(List <Category>
	 * loadedCategories) { Map<Integer,String> itemCostMap = new HashMap<Integer,
	 * String> (); if(loadedCategories != null) loadedCategories.forEach(x ->
	 * x.getItems().forEach(y -> { itemCostMap.put(y.getCost(),
	 * y.getItemName());})); return itemCostMap; }
	 * 
	 * public static Map<Integer, String> getRatingsforCategory(List <Category>
	 * loadedCategories) { Map<Integer, String> ratingsMap = new HashMap<Integer,
	 * String> (); if(loadedCategories != null) loadedCategories.forEach(x ->
	 * x.getItems().forEach(y -> { ratingsMap.put(y.getRating(),
	 * y.getItemName());})); return ratingsMap; }
	 */
	public static Map<Integer, String> getCostListforCategory(Category category)
	{   
		Map<Integer,String> itemCostMap =  new HashMap<Integer, String> ();
		if(category != null)
			category.getItems().forEach(y -> itemCostMap.put(y.getCost(), y.getItemName()));
		return itemCostMap;
	}
	
	public static Map<Integer, String> getRatingsforCategory(Category category)
	{   
		Map<Integer, String> ratingsMap =  new HashMap<Integer, String> ();
		if(category != null)
			category.getItems().forEach(y -> ratingsMap.put(y.getRating(), y.getItemName()));		
		return ratingsMap;
	}
	
	public static Item getOptimizedItemForCategory(List<Item> items)
	{
		Item optimizedItem = null;
		if(items!= null)
		{
			optimizedItem = items.get(0);
			int optimedVal = optimizedItem.getCost() + (5-optimizedItem.getRating());
			for(Item itemVar :items)
			{
				int loopVble = itemVar.getCost() + (5-itemVar.getRating());
				if(loopVble < optimedVal)
				{
					optimedVal = loopVble;
					optimizedItem = itemVar;
				}
			}
		}
		return optimizedItem;
	}
}
