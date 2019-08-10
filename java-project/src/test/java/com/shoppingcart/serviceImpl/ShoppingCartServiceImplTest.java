package com.shoppingcart.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import com.pojo.Category;
import com.pojo.Item;
import junit.framework.Assert;
import junit.framework.TestCase;

public class ShoppingCartServiceImplTest extends TestCase {

	private ShoppingCartServiceImpl impl = ShoppingCartServiceImpl.getInstance();
	private List<Category> loadedCategories = new ArrayList<Category> ();
	private List<Item> items = new ArrayList<Item>();
	private Exception exception  =null;
	
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public ShoppingCartServiceImplTest(String testName) {
		super(testName);
	}
	
	public void testLoadCategories() {
		impl.loadCategories(10,10,1,10,1,10,1,10);
		assertTrue( true );
	}
	
	public void testPassingZeroLoadCategories() {
		impl.loadCategories(0,0,0,0,0,0,0,0);
		assertTrue( true );
	}
	
	public void testPassingNegativeLoadCategories() {
		impl.loadCategories(-10,10,1,-10,-1,10,-1,10);
		assertTrue( true );
	}

	public void testPickAndAddToBasket() {
		items.clear();
		items.add(new Item(1,1,1,"Cat_Item_1"));
		items.add(new Item(1,1,1,"Cat_Item_2"));
		loadedCategories.add(new Category("Cat1", items));
		loadedCategories.add(new Category("Cat2", items));
		try {
			impl.pickAndAddToBasket(loadedCategories,5);
		} catch (Exception e) {
			exception = e;
		}
		Assert.assertNotNull(exception);
		Assert.assertEquals("Picking Items Incomplete:", exception.getMessage());
	}

	
	
	 public void testPassingNullPickAndAddToBasket() {
	  List<Item> items = new ArrayList<Item>(); 
	  items.add(new Item(1,1,1,"Cat_Item_1")); 
	  loadedCategories.add(new Category("Cat1", items));
	  try 
	  { 
		  impl.pickAndAddToBasket(null,0); 
	   } 
	  catch(Exception e) { exception =e; }
	  Assert.assertNull(exception);

	  }
	 
	public void testByPassingNullsCalculateTotalCostAndRating() {
		impl.calculateTotalCostAndRating(null, null);
	}
	
	public void testStartShopping() {
		
		impl.startShopping(20,10);
		assertTrue( true );
	}

	public void testPassingZeroInputsStartShopping() {
		
		impl.startShopping(0,0);
		assertTrue( true );
	}
	
	public void testPassingNegativeInputsStartShopping() {
		
		impl.startShopping(-2,-8);
		assertTrue( true );
	}
}
