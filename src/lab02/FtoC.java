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

/**
 * A simple program to ask the user for a temperature in F, and converts it to
 * Celsius.
 * 
 * @author: BRK 2012-fall
 */
package lab02;

import java.util.Scanner;

public class FtoC {
	public static void main(String[] args) {

		String option;
		do{
			// Prompt user for a Fahrenheit temp
			System.out.print("Enter a temperature in Fahrenheit: ");

			// Create the Scanner object, attached to console input
			Scanner in = new Scanner(System.in);

			// Read and store the Fahrenheit temp
			float fahTemp = in.nextInt();

			// Convert the temp to Celsius
			float celTemp = ((fahTemp - 32)*5)/9;

			// Output the results with correct formatting
			System.out.format(fahTemp + " F = %.1f C%n", celTemp);

			if (celTemp <= 0){
				System.out.println("Brrr... it is FREEZING out!");
			} else if (celTemp <= 15){
					System.out.println("It's a bit cool out!");
				} else if (celTemp <= 30){
						System.out.println("It's comfortably warm!");
					} else {
						System.out.println("It's HOT! I need A/C!");
					}
			Scanner userInput = new Scanner (System.in);
			System.out.print("Try again? [y | n]: ");
			option = userInput.next();
		}while (option.equals("y"));
		System.out.println("Goodbye!");
	}
}

