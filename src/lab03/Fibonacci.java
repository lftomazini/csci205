/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2015
* Instructor: Brian King
* Section: 10am
*
* Name: Luis Felipe Franco Candeo Tomazini and Anmol Singh
* Date: 09/01/2015
*
* Lab / Assignment: Lab03
*
* Description:Methods and String class
*
* *****************************************/

package lab03;

import java.util.Scanner;

/**
 * A simple class designed to give the user an opportunity to test a recursive
 * and non-recursive version of fibonacci
 *
 * Date: 2015-fall
 * @author BRK
 */
public class Fibonacci {

    /**
     * Compute the nth fibonacci number recursively
     *
     * @param n - the nth number to find
     * @return the nth number in the fibonacci sequence
     */
    public static int recFib(int n) {
	if (n == 0)
		return 0;
	if (n == 1)
		return 1;
	return recFib ( n-1 ) + recFib(n-2);
    }

    /**
     * Compute the nth fibonacci number non-recursively, using a while loop.
     *
     * @param n - the nth number to find
     * @return the nth number in the fibonacci sequence
     */
    public static int nonRecFib(int n) {
        int fibonacci_1 = 0;
	int fibonacci_2 = 1;
	
	while (n != 1){
		if (fibonacci_1 >= fibonacci_2) {
			fibonacci_2 += fibonacci_1;
		}
		else {
			fibonacci_1 += fibonacci_2;
		}
		n = n-1;

	}
	if (fibonacci_1 >= fibonacci_2)
		return fibonacci_1;
	else
		return fibonacci_2;
    }

    /**
     * Main program to test both fibonacci methods
     */
    public static void main(String[] args) {
        System.out.println("What fibonacci number do you want?");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
	long startTime = System.nanoTime();
        System.out.println("Recursive fib: " + recFib(n));
	System.out.println("Time to execute: " + (double)((System.nanoTime() - startTime)/1000000.0) + " ms");
	startTime = System.nanoTime();
        System.out.println("Non-recursive fib: " + nonRecFib(n));
	System.out.println("Time to execute: " + (double)((System.nanoTime() - startTime)/1000000.0) + " ms");
    }

}
