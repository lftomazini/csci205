/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2015
* Instructor: Brian King
* Section: 10am
*
* Name: Luis Felipe Franco Candeo Tomazini
* Name: Anmol Singh
* Date: 08/27/2015
*
* Lab / Assignment: Lab02
*
* Description: Basic Java I
*
* *****************************************/


package lab02;

import java.util.Scanner;

/**
 * This is a simple program to compute a proper amount of change given some
 * number of pennies.
 * 
 * @author BRK 2012-fall
 * 
 */
public class Change {

	final static int PENNIES_PER_DOLLAR = 100;
	final static int PENNIES_PER_QUARTER = 25;
	final static int PENNIES_PER_DIME = 10;
	final static int PENNIES_PER_NICKEL = 5;
		

	public static void main(String[] args) {
		String option;
		do{
			Scanner in = new Scanner(System.in);

			System.out.print("Enter the number of pennies: ");

			int pennies = in.nextInt();
			System.out.format("%d pennies breaks down to:%n", pennies);

			// Compute number of dollars
			int dollars = pennies / PENNIES_PER_DOLLAR;

			// Compute number of pennies leftover
			pennies %= PENNIES_PER_DOLLAR;

			// Compute number of quarters
			int quarters = pennies / PENNIES_PER_QUARTER;

			// Compute number of pennies leftover
			pennies %= PENNIES_PER_QUARTER;

			// Compute number of dime
			int dimes = pennies / PENNIES_PER_DIME;

			// Compute number of pennies leftover
			pennies %= PENNIES_PER_DIME;

			// Compute number of nickels
			int nickels = pennies / PENNIES_PER_NICKEL;

			// Compute number of pennies leftover
			pennies %= PENNIES_PER_NICKEL;

			// Output the results
			System.out.format("%3d dollars  = $%.2f%n", dollars, dollars * 1.0);  
			System.out.format("%3d quarters = $ %.2f%n", quarters, quarters * 0.25);
			System.out.format("%3d dimes    = $ %.2f%n", dimes, dimes * .10);
			System.out.format("%3d nickels  = $ %.2f%n", nickels, nickels * 0.05);
			System.out.format("%3d pennies  = $ %.2f%n", pennies, pennies * 0.01);
			Scanner userInput = new Scanner (System.in);
			System.out.print("Try again? [y | n]: ");
			option = userInput.next();
			}while (option.equals("y")||option.equals("Y"));
			System.out.println("Goodbye!");
	}
}
