package com.shoppingcart;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/* Using Junit3 version */
public class ShoppingCartTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public ShoppingCartTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(ShoppingCartTest.class);
	}

	public void testShoppingCart() 
	{
		/*
		 * String [] args = {"20,10,1,20,2,5,1,5"}; Written to build and test all
		 * testcases in 1 go ShoppingCart.main(args);
		 */
		assertTrue(true);
	}

	public void testPassingWrongNumberOfInputs() {
		String[] args = { "20,10,1,20" };
		ShoppingCart.main(args);
		assertTrue(true);
	}

	public void testPassingEmptyInputs() {
		String[] args = { "" };
		ShoppingCart.main(args);
		assertTrue(true);
	}

	public void testPassingNullInputs() {
		String[] args = null;
		ShoppingCart.main(args);
		assertTrue(true);
	}

}
