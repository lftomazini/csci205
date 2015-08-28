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

public class Sphere {

	public static final double PI = Math.PI;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter the radius of a sphere: ");
		int radius = in.nextInt();
		double volume = (4*PI*Math.pow(radius,3))/3;
		System.out.format("The volume is: %.2f%n",volume);
		System.out.println("Rounded to the nearest integer: " + Math.round(volume));
	}
}
