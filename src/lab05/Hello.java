/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Luis Felipe Franco Candeo Tomazini
 * Date: Sep 7, 2015
 * Time: 10:23:47 AM
 *
 * Project: csci205
 * Package: lab05
 * File: Hello
 * Description:
 *
 * ****************************************
 */
package lab05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * A simple program to aid in understanding NetBeans
 *
 * @author Luis Felipe Tomazini
 * @version 0.1
 */
public class Hello {

    private static final int NUM_INT = 10;

    /**
     * Prints an alternative "hello, World!"
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        greetUser();

        int[] x = getArrayOfRandomNums();
        System.out.println(Arrays.toString(x));
    }

    /**
     * Generates a random array
     *
     * @return the array with random numbers
     */
    private static int[] getArrayOfRandomNums() {
        Random rand = new Random();
        int[] x = new int[NUM_INT];
        for (int i = 0; i < NUM_INT; i++) {
            x[i] = rand.nextInt(100);
        }
        return x;
    }

    /**
     * Displays some initial messages
     *
     */
    private static void greetUser() {
        System.out.print("Hello. What is your name? ");
        Scanner in = new Scanner(System.in);
        String name = in.next();
        System.out.println(name + ", Becoming a good programmer takes practice.");
    }

}
