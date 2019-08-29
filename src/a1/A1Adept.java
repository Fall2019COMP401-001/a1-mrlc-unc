package a1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// The number of items in the store
		int itemCount = scan.nextInt();
		
		// The names of all the items in the store
		String[] items = new String[itemCount];
		
		// The prices of all the items in the store
		double[] prices = new double[itemCount];
		
		// Fills items[] and prices[] with item names and their prices respectively
		for (int i = 0; i < itemCount; i++) {
			
			items[i] = scan.next();
			prices[i] = scan.nextDouble();
		}
		
		// The number of customers
		int customerCount = scan.nextInt();
		
		// The total amount spent for each customer
		double[] totals = new double[customerCount];
		
		// The names of each customer
		String[] names = new String[customerCount];
		
		// Runs once for each customer
		for (int i = 0; i < customerCount; i++) {
			
			// Takes in first and last name and concatenates
			String firstName = scan.next();
			String lastName = scan.next();
			names[i] = firstName + " " + lastName;
			
			// The number of items bought by a particular customer
			int buyCount = scan.nextInt();
			
			// The amount spent by a customer
			double total = 0;
			
			// Runs once for each item a customer buys
			for (int j = 0; j < buyCount; j++) {
				
				// How many of each item the customer buys
				int ofEach = scan.nextInt();
				
				// The name of the specific item
				String ofWhat = scan.next();
				
				// Finds the index of a specific item to relate it to a price
				int itemIndex = Arrays.asList(items).indexOf(ofWhat);
				
				// Adds to the total the number of an item multiplied by its price
				total += ofEach * prices[itemIndex];
			}
			
			// The total for a customer is added to totals[], which contains all customers' totals
			totals[i] = total;
		}
		
		// Prints the max, min, and average amounts spent, as well as customer names
		System.out.println("Biggest: " + names[max(totals)] + " (" + String.format("%.2f", totals[max(totals)]) + ")");
		System.out.println("Smallest: " + names[min(totals)] + " (" + String.format("%.2f", totals[min(totals)]) + ")");
		System.out.println("Average: " + avg(totals));
		
	}
	
	// Finds the index of the maximum of an array, by default the first element
	public static int max(double[] input) {
		
		int max = 0;
		
		for (int i = 0; i < input.length; i++) {
			
			if (input[i] > input[max]) {
				
				max = i;
			}
		}
		
		return max;
	}
	
	// Finds the index of the minimum of an array, by default the first element
	public static int min(double[] input) {
			
			int min = 0;
			
			for (int i = 0; i < input.length; i++) {
				
				if (input[i] < input[min]) {
					
					min = i;
				}
			}
			
			return min;
		}
	
	// Finds the average of an array
	public static String avg(double[] input) {
		
		double total = 0;
		
		for (int i = 0; i < input.length; i++) {
			
			total += input[i];
		}
		
		double average = total / input.length;
		
		return String.format("%.2f", average);
	}
}
