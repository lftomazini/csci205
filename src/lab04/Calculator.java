/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2015
* Instructor: Brian King
* Section: 10am
*
* Name: Anmol Singh and Luis Felipe Franco Candeo Tomazini
* Date: 09/04/2015
*
* Lab / Assignment: 4
*
* Description: Arrays and Swtich
*
* *****************************************/

package lab04;

import java.util.Scanner;

/**
* A class designed to test standard deviation methods
* Date: 09/05/2015
* @author AS_LFFCT
*/

public class Calculator {
	/**
	* This method calculates the result of two numbers, depending on its operand.
	*
	*@param op1 The first double operand
	*@param operator The String containing the operator
	*@param op2 The second double operand 
	*@return type void
	*
	*/
	public static void calc (double op1, String operator, double op2) {
		switch (operator){
			case "+":
				System.out.println("The sum is " + (op1 + op2));
				break;
			case "-":
				System.out.println("The difference is " + (op1 - op2));
				break;			
			case "*":
				System.out.println("The product is " + (op1 * op2));
				break;	
			case "/":
				System.out.println("The quotient is " + (op1 / op2));
				break;	
			case "^":
				System.out.println("The power is " + (Math.pow(op1, op2)));
				break;	
			default:
				System.out.println("The remainder is " + (op1 % op2));
				break;	
			}
		}
	public static void main(String[] args) {

		System.out.println("Welcome to the calculator");
		System.out.println("Enter expression with two numeric operands and a single operator from +, -, *, /, %, or ^");
		String option = "y";
		while (option.equals("y")||option.equals("Y")) {
			System.out.print("Enter a simple arithmetic expression with spacing: ");
			Scanner in = new Scanner(System.in);
			if (in.hasNextDouble()) {
				double operand1 = in.nextDouble();
				if (in.hasNext()){
					String operator = in.next();
					if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("^") || operator.equals("%")) {
						if (in.hasNextDouble()) {
							double operand2 = in.nextDouble();
							calc (operand1, operator, operand2);
						} else {
						System.out.println("ERROR: cannot parse operand 2");
						} 
					} else {
						System.out.println("ERROR: " + operator + " is not a valid operator.");
					}
				} else {
					System.out.println("ERROR: " + in.next() + " is not a valid operator.");
				}
			} else {
				System.out.println("ERROR: cannot parse operand 1");   			
			}				
		Scanner userInput = new Scanner (System.in);
		System.out.print("Try again? [y | n]: ");
		option = userInput.next();
		}

	}
}
