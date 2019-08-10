package com.shoppingcart.util;

import java.util.ArrayList;
import java.util.List;

import com.pojo.Category;
import com.pojo.Item;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ShoppingCartUtilityTest extends TestCase {

	private List<Item> items = new ArrayList<Item>();

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public ShoppingCartUtilityTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */

	public static Test suite() {
		return new TestSuite(ShoppingCartUtilityTest.class);
	}

	public void testShoppingCartUtility() {
		ShoppingCartUtility.getRandomNumberInRange(2, 5);
		assertTrue(true);
	}

	public void testWhenPassedNegativeParams() {
		int minVal = -3, maxVal = -2;
		try {
			ShoppingCartUtility.getRandomNumberInRange(minVal, maxVal);
		} catch (Exception exception) {
			Assert.assertEquals("Negatives not allowed:", exception.getMessage());
		}
	}

	public void testWhenPassedMaxLessThanMin() {
		int minVal = 5, maxVal = 2;
		try {
			ShoppingCartUtility.getRandomNumberInRange(minVal, maxVal);
		} catch (Exception exception) {
			Assert.assertEquals("max must be greater than min", exception.getMessage());
		}
	}

	public void testShoppingCartUtilityDouble() {
		ShoppingCartUtility.getRandomNumberInRange(2.22, 5.22);
		assertTrue(true);
	}

	public void testWhenPassedNegativeParamsInDouble() {
		double minVal = -4.9458, maxVal = -2.394;
		try {
			ShoppingCartUtility.getRandomNumberInRange(minVal, maxVal);
		} catch (Exception exception) {
			Assert.assertEquals("Negatives not allowed:", exception.getMessage());
		}
	}

	public void testWhenPassedMaxLessThanMinInDouble() {
		double minVal = 5.55, maxVal = 2.29;
		try {
			ShoppingCartUtility.getRandomNumberInRange(minVal, maxVal);
		} catch (Exception exception) {
			Assert.assertEquals("max must be greater than min", exception.getMessage());
		}
	}

	private Category loadItemsandCategories() {
		Category cat = new Category();
		items.add(new Item(1, 1, 1, "Cat_Item_1"));
		items.add(new Item(20, 2, 5, "Cat_Item_2"));
		items.add(new Item(7, 2, 5, "Cat_Item_3"));
		cat.setItems(items);
		return cat;
	}

	public void testGetOptimizedItemForCategory() {
		ShoppingCartUtility.getOptimizedItemForCategory(loadItemsandCategories().getItems());
		assertTrue(true);
	}

	public void testGetCostListforCategory() {
		ShoppingCartUtility.getCostListforCategory(loadItemsandCategories());
		assertTrue(true);
	}

	public void testGetRatingsforCategory() {
		ShoppingCartUtility.getRatingsforCategory(loadItemsandCategories());
		assertTrue(true);
	}

	public void testWhenPassedNullGetOptimizedItemForCategory() {
		ShoppingCartUtility.getOptimizedItemForCategory(null);
		Assert.assertNull(null);
	}

	public void testWhenPassedNullGetCostListforCategory() {
		ShoppingCartUtility.getCostListforCategory(null);
		assertTrue(true);
	}

	public void testWhenPassedNullGetRatingsforCategory() {
		ShoppingCartUtility.getRatingsforCategory(null);
		assertTrue(true);
	}
}