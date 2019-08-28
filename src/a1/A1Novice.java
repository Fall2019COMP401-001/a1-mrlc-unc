package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// Takes the first integer to be the number of customers
		int numCustomers = scan.nextInt();
		
		/* Stores the total costs for each customer
		 * Initialize array of counts of size numCustomers */
		double[] totals = new double[numCustomers];
		
		/* Stores the names of each customer
		 * Initialize array of names with size numCustomers
		 */
		String[] names = new String[numCustomers];
		
		// Runs once for each customer, as determined by numCustomers
		for (int i = 0; i < numCustomers; i++) {
			
			// The first character is taken from the first name, and a "." is added
			String firstName = scan.next().charAt(0) + ".";
			String lastName = scan.next();
			// A name of the form "First Last" is stores in names[] as "F. Last"
			names[i] = firstName + " " + lastName;
			
			int numItems = scan.nextInt();
			
			// The initial total for a customer is zero
			double total = 0;
			
			// Runs once for each item, as determined by numItems
			for (int j = 0; j < numItems; j++) {
				
				// How many of an item
				int count = scan.nextInt();
				// Reads the name of the item, but doesn't do anything with it
				scan.next();
				// The price of a certain item
				double price = scan.nextDouble();
				// Adds to the total the price for several of a certain item
				total += count * price;
			}
			// A user's individual total is stored in totals[]
			totals[i] = total;
		}
		
		scan.close();
		
		for (int i = 0; i < numCustomers; i++) {
			
			// String.format is used to ensure two decimal places for all output numbers
			System.out.println(names[i] + ": " + String.format("%.2f", totals[i]));
		}
		
	}
}
