/**
 * 
 */
package com.shoppingcart;

import com.shoppingcart.serviceImpl.ShoppingCartServiceImpl;

/**
 * @author Divya Kanakanala
 *
 */
public class ShoppingCart {

	public ShoppingCart() {}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ShoppingCartServiceImpl obj = ShoppingCartServiceImpl.getInstance();
		if(args ==null ||args.length == 0)
		 obj.startShopping(20,10,1,20,2,5,1,5);
		else if(args !=null && args.length== 8)
		{ 
			try 
			{ obj.startShopping( 
				 Integer.parseInt(args[0]), Integer.parseInt(args[1]), 
				 Integer.parseInt(args[2]), Integer.parseInt(args[3]), 
				 Integer.parseInt(args[4]), Integer.parseInt(args[5]), 
				 Integer.parseInt(args[6]), Integer.parseInt(args[7])); 
			} catch(NumberFormatException nfe) {
				 obj.startShopping(20,10,1,20,2,5,1,5); }
		}
	}
}
