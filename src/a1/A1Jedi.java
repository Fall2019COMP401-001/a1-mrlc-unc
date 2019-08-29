package a1;

import java.util.Arrays;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Number of different kinds of items
		int itemCount = scan.nextInt();

		// The names of each item
		String[] itemNames = new String[itemCount];

		// The total purchases for each item
		int[] totalBought = new int[itemCount];

		// The number of different customers who bought each item
		int[] customersPerItem = new int[itemCount];

		// Runs once for each kind of item, setting the name and ignoring the price
		for (int i = 0; i < itemCount; i++) {
			
			itemNames[i] = scan.next();

			scan.nextDouble();
		}

		// Number of different customers
		int customerCount = scan.nextInt();

		// Runs once for each customer
		for (int i = 0; i < customerCount; i++) {
			// Ignores their name
			scan.next();
			scan.next();
			
			// Number of kinds of items a customer is buying (don't have to be different)
			int itemsPerCustomer = scan.nextInt();
			
			// Stores all of the customer's item names
			String[] customersItems = new String[itemsPerCustomer];
			
			// Runs once for each kind of item for a customer
			for (int j = 0; j < itemsPerCustomer; j++) {
				
				// The number of that item
				int numBought = scan.nextInt();
				// The name of the item
				String itemName = scan.next();
				
				// The array index for totalBought[] or itemNames[] of the item
				int itemIndex = Arrays.asList(itemNames).indexOf(itemName);
				
				// If the customer has not already bought the item, customersPerItem is incremented
				if (!Arrays.asList(customersItems).contains(itemName)) {
					customersPerItem[itemIndex]++;
				}
				
				// Adds the item name to customersItems[]
				customersItems[j] = itemName;
				
				// Updates the total number of an item bought
				totalBought[itemIndex] += numBought;
				
			}
		}
		// Prints a line for each item
		for (int i = 0; i < itemCount; i++) {
			
			// If there aren't zero of the item, prints "X customers bought y ITEM"
			if (totalBought[i] != 0) {
				
				System.out.println(customersPerItem[i] + " customers bought " + totalBought[i] + " " + itemNames[i]);
			// If there were zero, prints "No customers bought ITEM"	
			} else {
				
				System.out.println("No customers bought " + itemNames[i]);
			}
		}
	}
}
