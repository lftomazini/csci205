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

import java.util.Arrays;

/**
* A class designed to make operations with arrays
* Date: 09/04/2015
* @author AS_LFFCT
*/
public class ArrayChallenge {

	/**
	* This method concatenates two arrays into one.
	*
	*@param a1 the first array of double type
	*@param a2 the second array of double type
	*@return The concatenated array of <code>a1</code> and <code>a2</code>
	*
	*/
	public static double[] concat(double[] a1, double[] a2) {
		double[] concatenation = new double[a1.length + a2.length];
		for (int i=0; i < a1.length; i++){
			concatenation[i] = a1[i];
			}
		for (int j=0; j < a2.length; j++) {
			concatenation[ j + a1.length] = a2[j];
			}
		return concatenation;
	}
	/**
	* This method revereses the order of the array provided.
	*
	*@param a The array of double type to be reversed
	*@return The  array <code>a</code> reversed
	*
	*/
	public static double[] reverse(double[] a) {
		if (a.length == 1 || a.length ==0) {
			return a;
		}
		double[] a_1 = {a[a.length - 1]};
		double[] a_2 = Arrays.copyOfRange(a, 1, a.length-1);
		double[] a_3 = {a[0]};
		return concat(concat(a_1,reverse(a_2)),a_3); 	
	}

	/**
	* This method computes the alternating sum of the numbers within the array.
	*
	*@param a An array of double type numbers
	*@return The alternating <code>sum</code> of the array
	*
	*/

	public static double altSum(double[] a) {
		double sum = 0.0;
		for (int i=0; i < a.length; i++) {
			sum += a[i]*Math.pow(-1, i);
			}
		return sum;
	}

	/**
	* This method checks if the array provided is sorted already or not.
	*
	*@param a An array of double type numbers
	*@return boolean value true or false
	*
	*/

	public static boolean isSorted(double[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i+1]) {
				return false;
				}
		}
		return true;	
	}

	public static void main(String[] args) {
		double[] array1 = { 2, 3, 5, 7, 11 };
		double[] array2 = { 1, 4, 6, 8, 0 };
		System.out.printf("array1: %s\n", Arrays.toString(array1));
		System.out.printf("array2: %s\n", Arrays.toString(array2));
		System.out.printf("concat test: %s\n", Arrays.toString(concat(array1,array2)));
		System.out.printf("reverse test: %s\n",Arrays.toString(reverse(array1)));
		System.out.printf("altSum test: %.1f\n", altSum(concat(array1,array2)));
		System.out.printf("sorted test 1: %b\n", isSorted(array1));
		System.out.printf("sorted test 2: %b\n", isSorted(array2));
	}
}
