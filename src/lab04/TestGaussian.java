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

import java.util.Random;

/**
* A class designed to test standard deviation methods
* Date: 09/05/2015
* @author AS_LFFCT
*/
public class TestGaussian {

	//Class variable with the size of the array
	static final int MAX_NUMS = 100000;	


	/**
	* This method calculates the standard deviation
	*
	*@param nums[] the array for each the standard deviation will be calculated
	*@return The standard deviation array of <code>nums[]</code>
	*
	*/
	public static double calcStDev(double nums[]) {
		double mean = 0.0;
		for (int i =0; i < nums.length; i++) {
			mean += nums[i];
			}
		mean /= nums.length;
		double std = 0.0;
		for (int j=0; j < nums.length; j++) {
			 std += Math.pow( nums[j] - mean, 2);
			}
		std = Math.sqrt(std/nums.length);
		return std;
		}
	/**
	* This method calculates the standard deviation by an alternative approach
	*
	*@param nums[] the array for each the standard deviation will be calculated
	*@return The standard deviation array of <code>nums[]</code>
	*
	*/
	public static double calcAltStdev(double nums[]) {
		double mean = 0.0;
		double std = 0.0;		
		for (int i = 0; i < nums.length; i++) {
			mean += nums[i];
			std += nums[i]*nums[i];
			}
		mean /= nums.length;
		std = Math.sqrt(std/nums.length - mean*mean);
		return std;
		}

	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println("Generating " + MAX_NUMS + " numbers...");
		double[] nums = new double[MAX_NUMS];
		
		for (int i =0; i < MAX_NUMS; i++) {
			nums[i] = rand.nextGaussian();
			}
		double startTime = System.nanoTime();
		double sd = calcStDev(nums);
		double estimatedTime = (System.nanoTime() - startTime)/1000;
		System.out.println("sd:        " + sd);
		System.out.println("TIME:      " + estimatedTime + " usec");
 
		
		double startTime_2 = System.nanoTime();
		double alt_std = calcAltStdev(nums);
		double estimatedTime_2 = (System.nanoTime() - startTime_2)/1000;
		System.out.println("alt_sd:    " + alt_std);
		System.out.println("TIME:      " + estimatedTime_2 + " usec");
		System.out.format("alt_sd computed in %.2f%% of the time of sd%n", (estimatedTime_2/estimatedTime*100)); 
		}
}









